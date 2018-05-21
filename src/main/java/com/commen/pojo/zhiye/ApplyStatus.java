package com.commen.pojo.zhiye;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * 1、PACS系统发送更新的检查申请单给集成平台。
 * 2、集成平台将更新的检查申请单发送给HIS同步更新状态。
 */
@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"patientId","visitNo","visitType","operator","operatorTime","patientName","applyInfos"})
public class ApplyStatus implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "patientId")
    private String patientId; //HIS或体检病人ID

    @XmlElement(name = "visitNo")
    private String visitNo; //就诊号

    @XmlElement(name = "visitType")
    private String visitType; //就诊类型

    @XmlElement(name = "operator")
    private String operator; //操作人（姓名/工牌）

    @XmlElement(name = "operatorTime")
    private String operatorTime; //操作时间

    @XmlElement(name = "patientName")
    private String patientName; //病人姓名

    @XmlElementWrapper(name = "applyInfos")
    @XmlElement(name = "applyInfo")
    private List<ApplyInfo> applyInfos; //HIS或体检申请单号及单据状态

    public ApplyStatus() {
        super();
    }

    public ApplyStatus(String patientId, String visitNo, String visitType, String operator, String operatorTime, String patientName, List<ApplyInfo> applyInfos) {
        this.patientId = patientId;
        this.visitNo = visitNo;
        this.visitType = visitType;
        this.operator = operator;
        this.operatorTime = operatorTime;
        this.patientName = patientName;
        this.applyInfos = applyInfos;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getVisitNo() {
        return visitNo;
    }

    public void setVisitNo(String visitNo) {
        this.visitNo = visitNo;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(String operatorTime) {
        this.operatorTime = operatorTime;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public List<ApplyInfo> getApplyInfos() {
        return applyInfos;
    }

    public void setApplyInfos(List<ApplyInfo> applyInfos) {
        this.applyInfos = applyInfos;
    }

    @Override
    public String toString() {
        return "ApplyStatus{" +
                "patientId='" + patientId + '\'' +
                ", visitNo='" + visitNo + '\'' +
                ", visitType='" + visitType + '\'' +
                ", operator='" + operator + '\'' +
                ", operatorTime='" + operatorTime + '\'' +
                ", patientName='" + patientName + '\'' +
                ", applyInfos=" + applyInfos +
                '}';
    }
}
