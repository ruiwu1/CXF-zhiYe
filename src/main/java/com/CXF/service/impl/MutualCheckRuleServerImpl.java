package com.CXF.service.impl;

import com.CXF.mapper.GetStaffMapper;
import com.CXF.service.MutualCheckRuleServer;
import com.commen.pojo.MsgBody;
import com.commen.pojo.MsgHeader;
import com.commen.pojo.zhiye.*;
import com.commen.utils.CxfInvokeUtil;
import com.commen.utils.DateUtils;
import com.commen.utils.JaxbUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MutualCheckRuleServerImpl implements MutualCheckRuleServer{
    private  Logger logger = Logger.getLogger(MutualCheckRuleServerImpl.class);

    @Autowired
    private GetStaffMapper getStaffMapper;

    @Value(value = "${getStaff_wsdlurl}")
    private String wsdlUrl;

    @Value(value = "${Token_format}")
    private String format;

    @Value(value = "${Token_callOperator}")
    private  String callOperator;

    @Value(value = "${Token_certificate}")
    private  String certificate;

    @Value(value = "${getStaff_msgNo}")
    private  String msgNo;

    @Value(value = "${services_SendRadiationReport}")
    private String SendRadiationReport;

    @Value(value = "${services_GetRadiationApplyInfo}")
    private String GetRadiationApplyInfo;

    @Value(value = "${services_SendPacsReport}")
    private String SendPacsReport;

    private static Integer sendCount = 0;

    /**
     *
     * @param list
     * @return
     */
    //更新检查申请单信息 PACS系统发送更新的检查申请单给集成平台 --根据Examdata的ExamUID
	public String UpdateExamApplyStatus(List<ReturnContent> list) {
		for (ReturnContent returnContent : list) {
			ApplyStatus applyStatus = getStaffMapper.getExamApplyStatus(returnContent.getPatientId());
            //遍历获取申请单号和单据状态
            List<ExamItem> examItems = returnContent.getExamItems();

            List<ApplyInfo> applyInfolist = new ArrayList<ApplyInfo>();
            for (ExamItem examItem : examItems) {
                ApplyInfo applyInfo = getStaffMapper.getApplyStatus(examItem);
                applyInfolist.add(applyInfo);
            }
            applyStatus.setApplyInfos(applyInfolist);
            //序列化成xml数据
            String msgHeader = JaxbUtil.convertToXml(new MsgHeader(SendRadiationReport,format,callOperator,certificate,msgNo,DateUtils.getDateTime(),sendCount+""),"UTF-8");
            String msgBody = JaxbUtil.convertToXml(applyStatus,"UTF-8");
            //调用webservice接口
            //调用方法
            CxfInvokeUtil.invoke(wsdlUrl,msgHeader,msgBody);
        }
        return "更新检查申请单信息成功";
    }

    /**
     * 发送检查报告 传入PatientId HIS或体检病人ID
     * @param Report
     * @return
     */
    public String SendPacsReport(PacsReport Report) {
        try {
        PacsReport pacsReport = getStaffMapper.getPacsReport(Report);
        //获取applyno
        List<String> applyno =  getStaffMapper.getApplyNos(Report);
            pacsReport.setApplyNos(applyno);
        String msgBody = JaxbUtil.convertToXml(pacsReport, "UTF-8");
        //调用接口
        String msgHeader = JaxbUtil.convertToXml(new MsgHeader(SendPacsReport,format,callOperator,certificate,msgNo,DateUtils.getDateTime(),sendCount+""),"UTF-8");
        Object[] obs =CxfInvokeUtil.invoke(wsdlUrl,msgHeader,msgBody);
            return "发送检查报告成功";
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("发送检查报告失败");
            return null;
        }

    }

    public void testUpdateRadiationApplyStatus() {

    }

    /**
     * 1、获取检查申请单信息
     * @param examApplyInfo
     * @return
     */
    public  String GetExamApplyInfo(ExamApplyInfo examApplyInfo) {
        //传入msgHeader中serverName
        String Result = "";
        try {
            String msgHeader = JaxbUtil.convertToXml(new MsgHeader(GetRadiationApplyInfo,format,callOperator,certificate,msgNo,DateUtils.getDateTime(),sendCount+""),"UTF-8");
            String msgBody = JaxbUtil.convertToXml(examApplyInfo,"UTF-8");
            //调用方法
            Object[] obs =CxfInvokeUtil.invoke(wsdlUrl,msgHeader,msgBody);
            //假设客户端调用
            if(obs != null && obs.length > 0){
                Result = (String)obs[0];
            }
            /*//返回值序列化成申请单信息
            ExamApplyInfo examApplyInfo1 = JaxbUtil.converyToJavaBean(Result, ExamApplyInfo.class);
            //返回一个检查申请单的list列表
            List<ReturnContent> returnContents = examApplyInfo.getReturnContents();*/
            return Result;
        }catch (Exception e) {
            e.printStackTrace();
            logger.error("获取申请单信息错误");
            return null;
        }
    }

}
