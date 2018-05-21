package com.commen.pojo.zhiye;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 申请单信息
 */
@XmlRootElement(name="examItem")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"applyNo","emergencyFlag","clinicItemID","clinicItemName","charges","IsFee"
        ,"applyStatus","applyTime","applyDeptCode","applyDeptName","applyOperator","examClass"
        ,"examPart","examComments","executeDept","executeDeptName","examMethodName","deviceTypeName"})
public class ExamItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "applyNo")
    private String applyNo; //申请单号

    @XmlElement(name = "emergencyFlag")
    private String emergencyFlag; //急诊标志

    @XmlElement(name = "clinicItemID")
    private String clinicItemID; //HIS诊疗项目代码

    @XmlElement(name = "clinicItemName")
    private String clinicItemName; //诊疗项目名称

    @XmlElement(name = "charges")
    private String charges; //总费用

    @XmlElement(name = "IsFee")
    private String IsFee; //是否已经交费

    @XmlElement(name = "applyStatus")
    private String applyStatus; //申请单据状态

    @XmlElement(name = "applyTime")
    private String applyTime; //申请时间

    @XmlElement(name = "applyDeptCode")
    private String applyDeptCode; //申请科室

    @XmlElement(name = "applyDeptName")
    private String applyDeptName; //申请科室名称

    @XmlElement(name = "applyOperator")
    private String applyOperator; //申请医生

    @XmlElement(name = "examClass")
    private String examClass; //检查类别

    @XmlElement(name = "examPart")
    private String examPart; //检查部位

    @XmlElement(name = "examComments")
    private String examComments; //检查备注

    @XmlElement(name = "executeDept")
    private String executeDept; //执行科室代码

    @XmlElement(name = "executeDeptName")
    private String executeDeptName; //执行科室名称

    @XmlElement(name = "examMethodName")
    private String examMethodName; //检查方法

    @XmlElement(name = "deviceTypeName")
    private String deviceTypeName; //检查设别类型名称

    public ExamItem() {
        super();
    }

    public ExamItem(String applyNo, String emergencyFlag, String clinicItemID, String clinicItemName, String charges, String isFee, String applyStatus, String applyDate, String applyDeptCode, String applyDeptName, String applyOperator, String examClass, String examPart, String examComments, String executeDept, String executeDeptName, String examMethodName, String deviceTypeName) {
        this.applyNo = applyNo;
        this.emergencyFlag = emergencyFlag;
        this.clinicItemID = clinicItemID;
        this.clinicItemName = clinicItemName;
        this.charges = charges;
        IsFee = isFee;
        this.applyStatus = applyStatus;
        this.applyTime = applyTime;
        this.applyDeptCode = applyDeptCode;
        this.applyDeptName = applyDeptName;
        this.applyOperator = applyOperator;
        this.examClass = examClass;
        this.examPart = examPart;
        this.examComments = examComments;
        this.executeDept = executeDept;
        this.executeDeptName = executeDeptName;
        this.examMethodName = examMethodName;
        this.deviceTypeName = deviceTypeName;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getEmergencyFlag() {
        return emergencyFlag;
    }

    public void setEmergencyFlag(String emergencyFlag) {
        this.emergencyFlag = emergencyFlag;
    }

    public String getClinicItemID() {
        return clinicItemID;
    }

    public void setClinicItemID(String clinicItemID) {
        this.clinicItemID = clinicItemID;
    }

    public String getClinicItemName() {
        return clinicItemName;
    }

    public void setClinicItemName(String clinicItemName) {
        this.clinicItemName = clinicItemName;
    }

    public String getCharges() {
        return charges;
    }

    public void setCharges(String charges) {
        this.charges = charges;
    }

    public String getIsFee() {
        return IsFee;
    }

    public void setIsFee(String isFee) {
        IsFee = isFee;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void settApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApplyDeptCode() {
        return applyDeptCode;
    }

    public void setApplyDeptCode(String applyDeptCode) {
        this.applyDeptCode = applyDeptCode;
    }

    public String getApplyDeptName() {
        return applyDeptName;
    }

    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }

    public String getApplyOperator() {
        return applyOperator;
    }

    public void setApplyOperator(String applyOperator) {
        this.applyOperator = applyOperator;
    }

    public String getExamClass() {
        return examClass;
    }

    public void setExamClass(String examClass) {
        this.examClass = examClass;
    }

    public String getExamPart() {
        return examPart;
    }

    public void setExamPart(String examPart) {
        this.examPart = examPart;
    }

    public String getExamComments() {
        return examComments;
    }

    public void setExamComments(String examComments) {
        this.examComments = examComments;
    }

    public String getExecuteDept() {
        return executeDept;
    }

    public void setExecuteDept(String executeDept) {
        this.executeDept = executeDept;
    }

    public String getExecuteDeptName() {
        return executeDeptName;
    }

    public void setExecuteDeptName(String executeDeptName) {
        this.executeDeptName = executeDeptName;
    }

    public String getExamMethodName() {
        return examMethodName;
    }

    public void setExamMethodName(String examMethodName) {
        this.examMethodName = examMethodName;
    }

    public String getDeviceTypeName() {
        return deviceTypeName;
    }

    public void setDeviceTypeName(String deviceTypeName) {
        this.deviceTypeName = deviceTypeName;
    }

    @Override
    public String toString() {
        return "ExamItem{" +
                "applyNo='" + applyNo + '\'' +
                ", emergencyFlag='" + emergencyFlag + '\'' +
                ", clinicItemID='" + clinicItemID + '\'' +
                ", clinicItemName='" + clinicItemName + '\'' +
                ", charges='" + charges + '\'' +
                ", IsFee='" + IsFee + '\'' +
                ", applyStatus='" + applyStatus + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", applyDeptCode='" + applyDeptCode + '\'' +
                ", applyDeptName='" + applyDeptName + '\'' +
                ", applyOperator='" + applyOperator + '\'' +
                ", examClass='" + examClass + '\'' +
                ", examPart='" + examPart + '\'' +
                ", examComments='" + examComments + '\'' +
                ", executeDept='" + executeDept + '\'' +
                ", executeDeptName='" + executeDeptName + '\'' +
                ", examMethodName='" + examMethodName + '\'' +
                ", deviceTypeName='" + deviceTypeName + '\'' +
                '}';
    }
}
