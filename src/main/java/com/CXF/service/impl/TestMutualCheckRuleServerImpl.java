package com.CXF.service.impl;

import com.CXF.mapper.MutualCheckRuleMapper;
import com.CXF.model.ApplyStatusForMore;
import com.CXF.model.ExamData;
import com.CXF.model.ImageForMore;
import com.CXF.service.TestMutualCheckRuleServer;
import com.commen.cst.Const;
import com.commen.pojo.MsgHeader;
import com.commen.pojo.zhiye.ApplyInfo;
import com.commen.pojo.zhiye.ApplyStatus;
import com.commen.pojo.zhiye.Image;
import com.commen.pojo.zhiye.PacsReport;
import com.commen.utils.*;
import org.apache.log4j.Logger;
import org.dcm4che2.tool.dcm2jpg.Dcm2Jpg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:触发器触发向指定ws接口发送数据
 */
@Service
public class TestMutualCheckRuleServerImpl implements TestMutualCheckRuleServer {

    private Logger logger = Logger.getLogger(TestMutualCheckRuleServerImpl.class);

    private static Integer sendCount = 0;

    @Autowired
    private MutualCheckRuleMapper mutualCheckRuleMapper;

    //测试更新放射检查申请单信息
    public void testUpdateRadiationApplyStatus(String examUID,String examStatus) {
        Object[] invoke=null;
        String Result = "";
        List<ApplyInfo> list = new ArrayList<ApplyInfo>();
        //获取<<检查申请单状态变更通知>> 所需要的数据 --根绝ExamUID(触发器存储的表中存储ExamUID和节点变化详情的字段)
        ApplyStatusForMore applyStatusForMore =  mutualCheckRuleMapper.getExamApplyStatus(new ExamData(examUID,examStatus));
        //获取his申请单单号
        List<String> list1 = mutualCheckRuleMapper.getApplyNo(examUID);
        if (list1.size()>0){
            for (String applyNo:list1) {
                list.add(new ApplyInfo(applyNo,examStatus));
            }
        }
        //转换成xml格式
        ApplyStatus applyStatus = new ApplyStatus(applyStatusForMore.getPatientId(),applyStatusForMore.getVisitNo(),
                applyStatusForMore.getVisitType(),applyStatusForMore.getOperator(),applyStatusForMore.getOperatorTime(),
                applyStatusForMore.getPatientName(),list);
        String msgBody = JaxbUtil.convertToXml(applyStatus, "UTF-8");
        String dateTime = DateUtils.getDateTime();
        System.out.println("msgBody="+msgBody);
        if(applyStatusForMore.getSubjectClass().equals("1")){
            //放射检查
            //调用指定接口--更新放射申请单信息 UpdateRadiationApplyStatus
            String msgHeader = JaxbUtil.convertToXml(new MsgHeader("UpdateRadiationApplyStatus", Const.FORMAT,Const.CALLOPERATOR,Const.CERTIFICATE,Const.MSGNO,dateTime ,sendCount+""),"UTF-8");
            System.out.println("msgHeader="+msgHeader);
            invoke = CxfInvokeUtil.invoke(Const.WSDLURL, msgHeader, msgBody);
            logger.info("更新放射申请单信息成功,调用时间："+dateTime+",检查id为"+examUID);
        }else if(applyStatusForMore.getSubjectClass().equals("2")){
            //超声检查
            //调用指定接口--更新超声申请单信息 UpdateUltrasoundExamApplyStatus
            String msgHeader = JaxbUtil.convertToXml(new MsgHeader("UpdateUltrasoundExamApplyStatus",Const.FORMAT,Const.CALLOPERATOR,Const.ULTRASOUND,Const.MSGNO, dateTime,sendCount+""),"UTF-8");
            System.out.println("msgHeader="+msgHeader);
            invoke = CxfInvokeUtil.invoke(Const.WSDLURL,msgHeader,msgBody);
            logger.info("更新超声申请单信成功,调用时间："+dateTime+",检查id为"+examUID);
        }
        if(invoke != null && invoke.length > 0){
            Result = (String)invoke[0];
            logger.info(Result);
        }
    }

    //发送检查报告
    public void sendPacsReport(String examUID) {
        Object[] invoke=null;
        String Result = "";
        String reportPdfurl="";
        List<Image> imageList = new ArrayList<>();
        String dateTime = DateUtils.getDateTime();
        //获取检查报告
        PacsReport pacsReport = mutualCheckRuleMapper.selectPacsReportByExamUID(examUID);
        //获取图像信息
        List<ImageForMore> list = mutualCheckRuleMapper.selectPacsImageByExamUID(examUID);
        for (ImageForMore imageForMore: list) {
            if(imageForMore.getInternalType() == null){

            }else {
                if (imageForMore.getInternalType().equals("PrintRept")){//报告单--转换成pdf
                    String ftpFilePath = "pdf/radUser/"+DateUtils.getFtpNowDateTime();
                    String pdfFileName = imageForMore.getImageMainNo()+".pdf";
                    String filePath = imageForMore.getFilePath();
                    //O:\DicomImages\48500467434010411A2101\CT414542\
                    String substring = filePath.substring(1);

                    dcm2Pdf(imageForMore.getFilePath(),imageForMore.getFileName(),pdfFileName,ftpFilePath);//传入指定路径dcm文件
                    reportPdfurl+="ftp://"+Const.FTPHOSTNAME+"/"+ftpFilePath+"/"+pdfFileName+";";
                }else{
                    imageList.add(new Image(imageForMore.getInstanceUID(),imageForMore.getImageSubNo(),"2",""));
                }
            }
        }
        pacsReport.setReportPdfurl(reportPdfurl);
        pacsReport.setImages(imageList);
        //pdf报告地址
        String msgBody = JaxbUtil.convertToXml(pacsReport, "UTF-8");
        logger.info("msgBody:"+msgBody);
        if (pacsReport.getSubjectClass().equals("020201")){//超声
            String msgHeader = JaxbUtil.convertToXml(new MsgHeader("SendPacsReport",Const.FORMAT,Const.CALLOPERATOR,Const.ULTRASOUND,Const.MSGNO,dateTime ,sendCount+""),"UTF-8");
            invoke = CxfInvokeUtil.invoke(Const.WSDLURL, msgHeader, msgBody);
        }else if(pacsReport.getSubjectClass().equals("020202")){ //放射
            String msgHeader = JaxbUtil.convertToXml(new MsgHeader("SendPacsReport",Const.FORMAT,Const.CALLOPERATOR,Const.CERTIFICATE,Const.MSGNO,dateTime ,sendCount+""),"UTF-8");
            invoke = CxfInvokeUtil.invoke(Const.WSDLURL, msgHeader, msgBody);
        }
            logger.info("发送报告单信息成功,调用时间："+dateTime+",检查id为"+examUID);
        if(invoke != null && invoke.length > 0){
            Result = (String)invoke[0];
            logger.info(Result);
        }
    }

    /**
     * cm报告单转换成pdf并发送至pdf
     * @param dcmFilePath   dcm文件路径
     * @param dcmFileName   dcm文件名字
     * @param pdfFileName   pdf存储文件名字
     * @param ftpFilePath   pdf存储路径
     */
    private static void dcm2Pdf(String dcmFilePath,String dcmFileName, String pdfFileName,String ftpFilePath){
        String dcmFilePath2="";
        String substring = dcmFilePath.substring(0,1);
        if (substring.equals("O")){
            dcmFilePath2 = "o_interface\\"+dcmFilePath.substring(2,dcmFilePath.length()-1);
        }else if (substring.equals("E")){
            dcmFilePath2 = "o_interface\\"+dcmFilePath.substring(2,dcmFilePath.length()-1);
        }
        System.out.println(dcmFilePath2);

        FtpUtils ftp =new FtpUtils();
        String localPath="D:\\soapUI\\convant";
        File src = new File(localPath+"\\"+dcmFileName);
        String jpgPath = "D:\\soapUI\\convant\\convert.jsp";
        String pdfFilePath = "D:\\soapUI\\convant\\convert.pdf";
        //从ftp中下载文件
            ftp.downloadFile(dcmFilePath,dcmFileName,localPath);
        File dest = new File(jpgPath);
        Dcm2Jpg dcm2Jpg = new Dcm2Jpg();
        try {
            dcm2Jpg.convert(src, dest); //dcm转jpg
            Jpg2Pdf.convent(jpgPath,pdfFilePath); //jpg转pdf
        } catch (IOException e) {
            e.printStackTrace();
        }
        //传输至ftp
        ftp.uploadFile(ftpFilePath, pdfFileName, pdfFilePath);//pdf存储到文件中
    }

    public static void main(String[] args) {
        String filePath="E:\\DicomImages\\hfylkjyxgs\\MR78517\\";
        String substring = filePath.substring(0,1);
        String xml = "";
        if (substring.equals("O")){
            xml = "o_interface\\";
        }else if (substring.equals("E")){
        }

    }
/*
    E:\DicomImages\48500467434010411A2101\MR198933\	MR198933_0070.dcm
    O:\CD201802160421\48500467434010411A2101\MR198933\MR198933_0070.dcm
    O:\CD201802160421\48500467434010411A2101\MR198933\

    Administrator
2838548

    ftp://192.0.0.99:2121/o_interface/CD201802160421\48500467434010411A2101\MR198933\*/
}
