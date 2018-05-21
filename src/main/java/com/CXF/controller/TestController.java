package com.CXF.controller;

import com.CXF.mapper.TestMapper;
import com.CXF.mapper.TestPostgresqlMapper;
import com.CXF.model.postgreUser;
import com.CXF.service.GetStaffServer;
import com.CXF.service.MutualCheckRuleServer;
import com.CXF.service.TestMutualCheckRuleServer;
import com.commen.controller.BaseController;
import com.commen.cst.Const;
import com.commen.pojo.zhiye.PacsReport;
import com.commen.pojo.zhiye.ReturnContent;
import com.commen.utils.CxfInvokeUtil;
import com.commen.utils.FileUtils;
import com.commen.utils.FtpUtils;
import com.commen.utils.Jpg2Pdf;
import org.dcm4che2.tool.dcm2jpg.Dcm2Jpg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class TestController extends BaseController
{
    @Autowired
    private TestMutualCheckRuleServer mutualCheckRuleServer;

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private GetStaffServer getStaffServer;

    //更新检查申请单信息
/*    @RequestMapping(value = "/GetExamApplyInfo", method= RequestMethod.POST,produces = Const.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String GetExamApplyInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ExamApplyInfo examApplyInfo = new ExamApplyInfo();s
        //拼接msgBody
        examApplyInfo.setApplyNo("1");
        examApplyInfo.setVisitType("type");
        String s = mutualCheckRuleServer.GetExamApplyInfo(examApplyInfo);

        ExamApplyInfo examApplyInfo1 = new ExamApplyInfo();
        examApplyInfo.setReturnContents(list);
        String convert = JaxbUtil.convertToXml(examApplyInfo1, "UTF-8");
        retrn convert;
    }*/

    //更新放射检查申请单信息
    @RequestMapping(value = "/UpdateExamApplyStatus", method= RequestMethod.POST,produces = Const.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String UpdateExamApplyStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String wsdlUrl = "http://192.168.8.210:1506/services/WSInterface?wsdl";
        List<ReturnContent> list = new ArrayList<ReturnContent>();
        String msgHeader = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root>\n" +
                "<serverName>UpdateUltrasoundExamApplyStatus</serverName>\n" +
                "<format>xml</format>\t\n" +
                "<callOperator></callOperator>\n" +
                "<certificate>P7mxjSlqtYpanH4Rs8Eq8Q==</certificate>\n" +
                "<msgNo>GUID</msgNo>\n" +
                "<sendTime></sendTime>\n" +
                "<sendCount></sendCount>\n" +
                "</root>";
        String msgBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<root>\n" +
                "<patientId>0000013037</patientId>\n" +
                "<visitNo>30238081</visitNo>\n" +
                "<visitType>1</visitType>\n" +
                "<operator>ruiwu</operator>\n" +
                "<operatorTime>2017-12-18 09:37:05</operatorTime>\n" +
                "<patientName>李赟</patientName>\n" +
                "<applyInfos>\n" +
                "<applyInfo>\n" +
                "<applyNo>63908019</applyNo>\n" +
                "<applyStatus>5</applyStatus>\n" +
                "</applyInfo>\n" +
                "</applyInfos>\n" +
                "</root>";
        Object[] invoke = CxfInvokeUtil.invoke(wsdlUrl, msgHeader, msgBody);
        if(invoke != null && invoke.length > 0){
           String Result = (String)invoke[0];
            System.out.println(Result);
        }
        return "需求有问题";
    }

    //更新超声检查申请单信息
    @RequestMapping(value = "/UpdateUltrasoundExamApplyStatus", method= RequestMethod.POST,produces = Const.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String UpdateUltrasoundExamApplyStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String wsdlUrl = "http://192.168.8.210:1506/services/WSInterface?wsdl";
        List<ReturnContent> list = new ArrayList<ReturnContent>();
        String msgHeader = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root>\n" +
                "<serverName>UpdateRadiationApplyStatus</serverName>\n" +
                "<format>xml</format>\t\n" +
                "<callOperator></callOperator>\n" +
                "<certificate>sUTC9mOhv+ql3sMpjFq8M1feqa2GnWJK</certificate>\n" +
                "<msgNo>GUID</msgNo>\n" +
                "<sendTime></sendTime>\n" +
                "<sendCount></sendCount>\n" +
                "</root>";
        String msgBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<root>\n" +
                "<patientId>0000013037</patientId>\n" +
                "<visitNo>30238081</visitNo>\n" +
                "<visitType>1</visitType>\n" +
                "<operator>ruiwu</operator>\n" +
                "<operatorTime>2017-12-18 09:37:05</operatorTime>\n" +
                "<patientName>李赟</patientName>\n" +
                "<applyInfos>\n" +
                "<applyInfo>\n" +
                "<applyNo>63908019</applyNo>\n" +
                "<applyStatus>5</applyStatus>\n" +
                "</applyInfo>\n" +
                "</applyInfos>\n" +
                "</root>";
        Object[] invoke = CxfInvokeUtil.invoke(wsdlUrl, msgHeader, msgBody);
        if(invoke != null && invoke.length > 0){
            String Result = (String)invoke[0];
            System.out.println(Result);
        }
        return "需求有问题";
    }
    //发送检查报告
    @RequestMapping(value = "/SendPacsReport", method= RequestMethod.POST,produces = Const.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String SendPacsReport(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String wsdlUrl = "http://192.168.8.210:1506/services/WSInterface?wsdl";
        String msgHeader = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root>\n" +
                "<serverName>SendPacsReport</serverName>\n" +
                "<format>xml</format>\t\n" +
                "<callOperator></callOperator>\n" +
                "<certificate>P7mxjSlqtYpanH4Rs8Eq8Q==</certificate>\n" +
                "<msgNo>GUID</msgNo>\n" +
                "<sendTime></sendTime>\n" +
                "<sendCount></sendCount>\n" +
                "</root>";
        String msgBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<root>\n" +
                "<patientId>0000013037</patientId>\n" +
                "<visitNo>30238081</visitNo>\n" +
                "<visitType>1</visitType>\n" +
                "<emergencyFlag/>\n" +
                "<patientName>李赟</patientName>\n" +
                "<patientSex>女</patientSex>\n" +
                "<patientBirthDay/>\n" +
                "<patientAge>41</patientAge>\n" +
                "<bedNo/>\n" +
                "<diagnoseCode>M51.202</diagnoseCode>\n" +
                "<diagnoseName>腰椎间盘突出</diagnoseName>\n" +
                "<applyNos>\n" +
                "<applyNo>63908019</applyNo>\n" +
                "</applyNos>\n" +
                "<applyOperator>王胜/ws</applyOperator>\n" +
                "<applyDeptCode>222</applyDeptCode>\n" +
                "<applyDeptName>神经外科门诊</applyDeptName>\n" +
                "<applyStatus>2</applyStatus>\n" +
                "<applyTime>2017-12-18 09:37:05</applyTime>\n" +
                "<reportNo>报告单号</reportNo>\n" +
                "<reportTitle>报告标题</reportTitle>\n" +
                "<subjectClass>020202</subjectClass>\n" +
                "<itemCode>检查项目代码</itemCode>\n" +
                "<itemName>检查项目名称</itemName>\n" +
                "<examMethod>检查方法</examMethod>\n" +
                "<examPart>检查部位</examPart>\n" +
                "<examPartDesc>检查部位描述</examPartDesc>\n" +
                "<visitStateDesc>测试</visitStateDesc>\n" +
                "<examImgDesc>测试</examImgDesc>\n" +
                "<examPurpose>测算</examPurpose>\n" +
                "<examDevice>pcas</examDevice>\n" +
                "<examDeviceName>pcas</examDeviceName>\n" +
                "<registerTime>2017-01-10</registerTime>\n" +
                "<registerOperator>ruiwu</registerOperator>\n" +
                "<examTime>2017-01-10</examTime>\n" +
                "<examDept>放射科</examDept>\n" +
                "<examOperator>ruiwu</examOperator>\n" +
                "<reportTime>2017-01-25</reportTime>\n" +
                "<reportOperator>ruiwu</reportOperator>\n" +
                "<auditTime>2017-01-01</auditTime>\n" +
                "<auditOperator>ruiwu</auditOperator>\n" +
                "<printTime>2017-01-17</printTime> \n" +
                "<printOperator>ruiwu</printOperator>\n" +
                "<remark>备注</remark>\n" +
                "</root>";
       /* JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf
                .createClient("http://localhost:7002/card/services/HelloWorld?wsdl");*/
        Object[] invoke = CxfInvokeUtil.invoke(wsdlUrl, msgHeader, msgBody);
        if(invoke != null && invoke.length > 0){
            String Result = (String)invoke[0];
            System.out.println(Result);
        }
        return "需求有问题";
    }

    //测试获取token
    @RequestMapping(value = "/testToken", method= RequestMethod.POST,produces = Const.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void testToken(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException {
        System.out.println("测试");
        System.out.println(Const.WSDLURL);
        System.out.println(Const.FORMAT);
        String file = "F:/CT237849_0002.dcm";
        String filePath = "D:\\soapUI\\convant\\convert.pdf";
        //dcm2Pdf("backup\tasks","CT237849_0002.dcm","CT237849_0002.pdf","pdf/radUser");
      /*  dcm2Pdf(file,filePath);
        //传输至ftp
        FtpUtils ftp =new FtpUtils();
        ftp.uploadFile("pdf/radUser/2018-05-18", "convert.pdf", filePath);*/
       // getReportByFtp();
        mutualCheckRuleServer.sendPacsReport("97EE3133-9A2D-44C6-99CE-01D06B99746C");
    }

    private static void dcm2Pdf(String dcmFilePath,String dcmFileName, String pdfFileName,String ftpFilePath){
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

}
