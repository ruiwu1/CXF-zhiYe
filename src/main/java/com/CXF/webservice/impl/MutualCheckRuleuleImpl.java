package com.CXF.webservice.impl;

import com.CXF.service.MutualCheckRuleServer;
import com.CXF.webservice.MutualCheckRule;
import com.commen.pojo.zhiye.ApplyInfo;
import com.commen.pojo.zhiye.ExamApplyInfo;
import com.commen.pojo.zhiye.PacsReport;
import com.commen.pojo.zhiye.ReturnContent;
import com.commen.utils.JaxbUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;
import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * @author ruiwu
 * @version V1.0
 * @Description: 新增需求：根据检查部门区分
 */
@WebService(serviceName = "MutualCheckRuleService",
        targetNamespace ="http://impl.webservice.CXF.com",
        endpointInterface = "com.CXF.webservice.MutualCheckRule")
public class MutualCheckRuleuleImpl implements MutualCheckRule {

    @Autowired
    private MutualCheckRuleServer mutualCheckRuleServer;

    /**
     * 1、获取检查申请单信息
     *  <applyNo>申请单号/病人ID/ic卡号、住院号</applyNo>
     *  <visitType>就诊类型1门急诊2住院 3体检</visitType>
     */

    public String GetUltrasoundExamApplyInfo(String xmlparam) {
        try {
            //1.1、解析xml数据
            ExamApplyInfo examApplyInfo = JaxbUtil.converyToJavaBean(xmlparam, ExamApplyInfo.class);
            //1.2 调用接口  暂时返回string字符串
            String result = mutualCheckRuleServer.GetExamApplyInfo(examApplyInfo);
            return result;
        } catch (JAXBException e) {
            e.printStackTrace();
            return "error:错误提示：获取超声检查申请单失败";
        }

    }
    //2、更新检查申请单信息
    public String UpdateUltrasoundExamApplyStatus(String xmlparam){
        try {
            ExamApplyInfo examApplyInfo = JaxbUtil.converyToJavaBean(xmlparam, ExamApplyInfo.class);
            List<ReturnContent> returnContents = examApplyInfo.getReturnContents();
            String status = mutualCheckRuleServer.UpdateExamApplyStatus(returnContents);
            //返回的状态值
            return status;
        } catch (JAXBException e) {
            e.printStackTrace();
            return "error:错误提示：更新超声检查申请单失败";
        }
    }
    //3、发送检查报告
    public String SendUltrasoundReport(String xmlparam) {
        try {
            PacsReport pacsReport = JaxbUtil.converyToJavaBean(xmlparam, PacsReport.class);
            String status = mutualCheckRuleServer.SendPacsReport(pacsReport);
            return status;
        } catch (JAXBException e) {
            e.printStackTrace();
            return "error:错误提示：发送超声检查申请单失败";
        }
    }

    public String GetRadiationApplyInfo(String xmlparam) {
        return null;
    }

    public String UpdateRadiationApplyStatus(String xmlparam) {
        return null;
    }

    public String SendRadiationReport(String xmlparam) {
        return null;
    }
}
