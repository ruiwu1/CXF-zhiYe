package com.commen.pojo.zhiye;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * 3.3.1.检查报告
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@XmlType(propOrder={"patientId","visitNo","visitType","emergencyFlag","patientName","patientSex","patientBirthDay"
        ,"patientAge","bedNo","diagnoseCode","diagnoseName","medicalHistory","applyNos","applyOperator"
        ,"applyDeptCode","applyDeptName","applyTime","reportNo","reportTitle","subjectClass","itemCode"
        ,"itemName","examMethod","examPart","examPartDesc","visitStateDesc","examImgDesc","examPurpose"
        ,"examDevice","examDeviceName","registerTime","registerOperator","examTime","examDept"
        ,"examOperator","reportTime","reportOperator","auditTime","auditOperator","printTime"
        ,"printOperator","remark","parmDetails","reportPdfurl","images","abnormalFlag"})
public class PacsReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "patientId")
    private String patientId; //HIS或体检病人ID

    @XmlElement(name = "visitNo")
    private String visitNo; //就诊号（门诊挂号号/住院号）

    @XmlElement(name = "visitType")
    private String visitType; //就诊类型1门急诊2住院 3体检

    @XmlElement(name = "emergencyFlag")
    private String emergencyFlag; //急诊标志，0普通，1急诊

    @XmlElement(name = "patientName")
    private String patientName; //

    @XmlElement(name = "patientSex")
    private String patientSex; //性别

    @XmlElement(name = "patientBirthDay")
    private String patientBirthDay; //出生日期

    @XmlElement(name = "patientAge")
    private String patientAge; //年龄

    @XmlElement(name = "bedNo")
    private String bedNo; //床号

    @XmlElement(name = "diagnoseCode")
    private String diagnoseCode; //诊断代码

    @XmlElement(name = "diagnoseName")
    private String diagnoseName; //诊断名称

    @XmlElement(name = "medicalHistory")
    private String medicalHistory; //病史

    @XmlElementWrapper(name = "applyNos")
    @XmlElement(name = "applyNo")
    private List<String> applyNos; //

    @XmlElement(name = "applyOperator")
    private String applyOperator; //申请人（姓名/工牌）

    @XmlElement(name = "applyDeptCode")
    private String applyDeptCode; //申请科室代码

    @XmlElement(name = "applyDeptName")
    private String applyDeptName; //申请科室名称

    @XmlElement(name = "applyTime")
    private String applyTime; //申请时间

    @XmlElement(name = "reportNo")
    private String reportNo; //报告单号

    @XmlElement(name = "reportTitle")
    private String reportTitle; //报告标题

    @XmlElement(name = "subjectClass")
    private String subjectClass; //检查项目名称

    @XmlElement(name = "itemCode")
    private String itemCode; //检查项目代码

    @XmlElement(name = "itemName")
    private String itemName; //检查项目名称

    @XmlElement(name = "examMethod")
    private String examMethod; //检查方法

    @XmlElement(name = "examPart")
    private String examPart; //检查部位

    @XmlElement(name = "examPartDesc")
    private String examPartDesc; //检查部位描述

    @XmlElement(name = "visitStateDesc")
    private String visitStateDesc; //病情描述

    @XmlElement(name = "examImgDesc")
    private String examImgDesc; //影像描述

    @XmlElement(name = "examPurpose")
    private String examPurpose; //检查目的

    @XmlElement(name = "examDevice")
    private String examDevice; //检查设备

    @XmlElement(name = "examDeviceName")
    private String examDeviceName; //检查设备名称

    @XmlElement(name = "registerTime")
    private String registerTime; //登记时间

    @XmlElement(name = "registerOperator")
    private String registerOperator; //登记人（姓名/工牌）

    @XmlElement(name = "examTime")
    private String examTime; //检查时间

    @XmlElement(name = "examDept")
    private String examDept; //检查科室

    @XmlElement(name = "examOperator")
    private String examOperator; //检查人（姓名/工牌）

    @XmlElement(name = "reportTime")
    private String reportTime; //报告时间

    @XmlElement(name = "reportOperator")
    private String reportOperator; //报告人（姓名/工牌）

    @XmlElement(name = "auditTime")
    private String auditTime; //审核时间

    @XmlElement(name = "auditOperator")
    private String auditOperator; //审核人（姓名/工牌）

    @XmlElement(name = "printTime")
    private String printTime; //打印时间

    @XmlElement(name = "printOperator")
    private String printOperator; //打印人员（姓名/工牌）

    @XmlElement(name = "remark")
    private String remark; //备注

    @XmlElementWrapper(name = "parmDetails")
    @XmlElement(name = "parmDetail")
    private List<ParmDetail> parmDetails; //科室代码、科室名称

    @XmlElement(name = "reportPdfurl")
    private String reportPdfurl; //PDF报告Url地址

    @XmlElementWrapper(name = "images")
    @XmlElement(name = "image")
    private List<Image> images; //没有单独图像可不提供

    @XmlElement(name = "abnormalFlag")
    private String abnormalFlag; //异常标志0正常1异常

    public PacsReport() {
        super();
    }

    public PacsReport(String patientId, String visitNo, String visitType, String emergencyFlag, String patientName,
                      String patientSex, String patientBirthDay, String patientAge, String bedNo, String diagnoseCode,
                      String diagnoseName, String medicalHistory, List<String> applyNos, String applyOperator, String applyDeptCode,
                      String applyDeptName, String applyTime, String reportNo, String reportTitle, String subjectClass,
                      String itemCode, String itemName, String examMethod, String examPart, String examPartDesc, String visitStateDesc,
                      String examImgDesc, String examPurpose, String examDevice, String examDeviceName, String registerTime, String registerOperator,
                      String examTime, String examDept, String examOperator, String reportTime, String reportOperator, String auditTime, String auditOperator,
                      String printTime, String printOperator, String remark, List<ParmDetail> parmDetails, String reportPdfurl, List<Image> images, String abnormalFlag) {
        this.patientId = patientId;
        this.visitNo = visitNo;
        this.visitType = visitType;
        this.emergencyFlag = emergencyFlag;
        this.patientName = patientName;
        this.patientSex = patientSex;
        this.patientBirthDay = patientBirthDay;
        this.patientAge = patientAge;
        this.bedNo = bedNo;
        this.diagnoseCode = diagnoseCode;
        this.diagnoseName = diagnoseName;
        this.medicalHistory = medicalHistory;
        this.applyNos = applyNos;
        this.applyOperator = applyOperator;
        this.applyDeptCode = applyDeptCode;
        this.applyDeptName = applyDeptName;
        this.applyTime = applyTime;
        this.reportNo = reportNo;
        this.reportTitle = reportTitle;
        this.subjectClass = subjectClass;
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.examMethod = examMethod;
        this.examPart = examPart;
        this.examPartDesc = examPartDesc;
        this.visitStateDesc = visitStateDesc;
        this.examImgDesc = examImgDesc;
        this.examPurpose = examPurpose;
        this.examDevice = examDevice;
        this.examDeviceName = examDeviceName;
        this.registerTime = registerTime;
        this.registerOperator = registerOperator;
        this.examTime = examTime;
        this.examDept = examDept;
        this.examOperator = examOperator;
        this.reportTime = reportTime;
        this.reportOperator = reportOperator;
        this.auditTime = auditTime;
        this.auditOperator = auditOperator;
        this.printTime = printTime;
        this.printOperator = printOperator;
        this.remark = remark;
        this.parmDetails = parmDetails;
        this.reportPdfurl = reportPdfurl;
        this.images = images;
        this.abnormalFlag = abnormalFlag;
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

    public String getEmergencyFlag() {
        return emergencyFlag;
    }

    public void setEmergencyFlag(String emergencyFlag) {
        this.emergencyFlag = emergencyFlag;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(String patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientBirthDay() {
        return patientBirthDay;
    }

    public void setPatientBirthDay(String patientBirthDay) {
        this.patientBirthDay = patientBirthDay;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getDiagnoseCode() {
        return diagnoseCode;
    }

    public void setDiagnoseCode(String diagnoseCode) {
        this.diagnoseCode = diagnoseCode;
    }

    public String getDiagnoseName() {
        return diagnoseName;
    }

    public void setDiagnoseName(String diagnoseName) {
        this.diagnoseName = diagnoseName;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<String> getApplyNos() {
        return applyNos;
    }

    public void setApplyNos(List<String> applyNos) {
        this.applyNos = applyNos;
    }

    public String getApplyOperator() {
        return applyOperator;
    }

    public void setApplyOperator(String applyOperator) {
        this.applyOperator = applyOperator;
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

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getSubjectClass() {
        return subjectClass;
    }

    public void setSubjectClass(String subjectClass) {
        this.subjectClass = subjectClass;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getExamMethod() {
        return examMethod;
    }

    public void setExamMethod(String examMethod) {
        this.examMethod = examMethod;
    }

    public String getExamPart() {
        return examPart;
    }

    public void setExamPart(String examPart) {
        this.examPart = examPart;
    }

    public String getExamPartDesc() {
        return examPartDesc;
    }

    public void setExamPartDesc(String examPartDesc) {
        this.examPartDesc = examPartDesc;
    }

    public String getVisitStateDesc() {
        return visitStateDesc;
    }

    public void setVisitStateDesc(String visitStateDesc) {
        this.visitStateDesc = visitStateDesc;
    }

    public String getExamImgDesc() {
        return examImgDesc;
    }

    public void setExamImgDesc(String examImgDesc) {
        this.examImgDesc = examImgDesc;
    }

    public String getExamPurpose() {
        return examPurpose;
    }

    public void setExamPurpose(String examPurpose) {
        this.examPurpose = examPurpose;
    }

    public String getExamDevice() {
        return examDevice;
    }

    public void setExamDevice(String examDevice) {
        this.examDevice = examDevice;
    }

    public String getExamDeviceName() {
        return examDeviceName;
    }

    public void setExamDeviceName(String examDeviceName) {
        this.examDeviceName = examDeviceName;
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
    }

    public String getRegisterOperator() {
        return registerOperator;
    }

    public void setRegisterOperator(String registerOperator) {
        this.registerOperator = registerOperator;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getExamDept() {
        return examDept;
    }

    public void setExamDept(String examDept) {
        this.examDept = examDept;
    }

    public String getExamOperator() {
        return examOperator;
    }

    public void setExamOperator(String examOperator) {
        this.examOperator = examOperator;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportOperator() {
        return reportOperator;
    }

    public void setReportOperator(String reportOperator) {
        this.reportOperator = reportOperator;
    }

    public String getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(String auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditOperator() {
        return auditOperator;
    }

    public void setAuditOperator(String auditOperator) {
        this.auditOperator = auditOperator;
    }

    public String getPrintTime() {
        return printTime;
    }

    public void setPrintTime(String printTime) {
        this.printTime = printTime;
    }

    public String getPrintOperator() {
        return printOperator;
    }

    public void setPrintOperator(String printOperator) {
        this.printOperator = printOperator;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<ParmDetail> getParmDetails() {
        return parmDetails;
    }

    public void setParmDetails(List<ParmDetail> parmDetails) {
        this.parmDetails = parmDetails;
    }

    public String getReportPdfurl() {
        return reportPdfurl;
    }

    public void setReportPdfurl(String reportPdfurl) {
        this.reportPdfurl = reportPdfurl;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getAbnormalFlag() {
        return abnormalFlag;
    }

    public void setAbnormalFlag(String abnormalFlag) {
        this.abnormalFlag = abnormalFlag;
    }

    @Override
    public String toString() {
        return "PacsReport{" +
                "patientId='" + patientId + '\'' +
                ", visitNo='" + visitNo + '\'' +
                ", visitType='" + visitType + '\'' +
                ", emergencyFlag='" + emergencyFlag + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientSex='" + patientSex + '\'' +
                ", patientBirthDay='" + patientBirthDay + '\'' +
                ", patientAge='" + patientAge + '\'' +
                ", bedNo='" + bedNo + '\'' +
                ", diagnoseCode='" + diagnoseCode + '\'' +
                ", diagnoseName='" + diagnoseName + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", applyNos=" + applyNos +
                ", applyOperator='" + applyOperator + '\'' +
                ", applyDeptCode='" + applyDeptCode + '\'' +
                ", applyDeptName='" + applyDeptName + '\'' +
                ", applyTime='" + applyTime + '\'' +
                ", reportNo='" + reportNo + '\'' +
                ", reportTitle='" + reportTitle + '\'' +
                ", subjectClass='" + subjectClass + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", examMethod='" + examMethod + '\'' +
                ", examPart='" + examPart + '\'' +
                ", examPartDesc='" + examPartDesc + '\'' +
                ", visitStateDesc='" + visitStateDesc + '\'' +
                ", examImgDesc='" + examImgDesc + '\'' +
                ", examPurpose='" + examPurpose + '\'' +
                ", examDevice='" + examDevice + '\'' +
                ", examDeviceName='" + examDeviceName + '\'' +
                ", registerTime='" + registerTime + '\'' +
                ", registerOperator='" + registerOperator + '\'' +
                ", examTime='" + examTime + '\'' +
                ", examDept='" + examDept + '\'' +
                ", examOperator='" + examOperator + '\'' +
                ", reportTime='" + reportTime + '\'' +
                ", reportOperator='" + reportOperator + '\'' +
                ", auditTime='" + auditTime + '\'' +
                ", auditOperator='" + auditOperator + '\'' +
                ", printTime='" + printTime + '\'' +
                ", printOperator='" + printOperator + '\'' +
                ", remark='" + remark + '\'' +
                ", parmDetails=" + parmDetails +
                ", reportPdfurl='" + reportPdfurl + '\'' +
                ", images=" + images +
                ", abnormalFlag='" + abnormalFlag + '\'' +
                '}';
    }
}
