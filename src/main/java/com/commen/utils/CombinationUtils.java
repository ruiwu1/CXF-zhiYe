package com.commen.utils;

import com.commen.pojo.MsgHeader;
import com.commen.pojo.zhiye.ExamApplyInfo;
import com.commen.pojo.zhiye.ReturnContent;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ruiwu
 * @version V1.0
 * @Description:公共的组合（超声/放射）
 */
@Component("combinationUtils")
public class CombinationUtils {
    private String wsdlUrl;
    private String format; //固定xml
    private String callOperator; //调用操作者
    private String certificate; //放射凭证号
    private String ultrasound;//超声凭证号
    private String msgNo; //消息唯一标识：GUID
    private String serverName;
    private static Integer sendCount = 0;

    public String getWsdlUrl() {
        return wsdlUrl;
    }
    @Value(value = "#{configProperties.getStaff_wsdlurl}")
    public void setWsdlUrl(String wsdlUrl) {
        this.wsdlUrl = wsdlUrl;
    }

    public String getFormat() {
        return format;
    }

    @Value(value = "#{configProperties.Token_format}")
    public void setFormat(String format) {
        this.format = format;
    }

    public String getCallOperator() {
        return callOperator;
    }
    @Value(value = "#{configProperties.Token_callOperator}")
    public void setCallOperator(String callOperator) {
        this.callOperator = callOperator;
    }

    public String getCertificate() {
        return certificate;
    }
    @Value(value = "#{configProperties.Token_certificate}")
    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getUltrasound() {
        return ultrasound;
    }
    @Value(value = "#{configProperties.Token_Ultrasound}")
    public void setUltrasound(String ultrasound) {
        this.ultrasound = ultrasound;
    }

    public String getMsgNo() {
        return msgNo;
    }
    @Value(value = "#{configProperties.getStaff_msgNo}")
    public void setMsgNo(String msgNo) {
        this.msgNo = msgNo;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public static Integer getSendCount() {
        return sendCount;
    }

    public static void setSendCount(Integer sendCount) {
        CombinationUtils.sendCount = sendCount;
    }


}
