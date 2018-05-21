package com.commen.pojo.zhiye;


import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * 申请单信息
 */
@XmlRootElement(name="returnContent")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"patientId","visitNo","visitType","safetyNo","icCardNo","patientName","patientSex"
        ,"patientAge","patientBirthDay","identityCardNo","employerName","contactAddress","telephone"
        ,"patientCountry","patientNation","bedNo","visitDeptCode","visitDeptName","visitOperator","diagnoseCode"
        ,"diagnoseName","abstractHistory","clinicInfo","sickSynptom","examItems"})
public class ReturnContent implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "patientId")
    private String patientId; //病人id

    @XmlElement(name = "visitNo")
    private String visitNo; //门诊挂号号/住院号

    @XmlElement(name = "visitType")
    private String visitType; //就诊类型

    @XmlElement(name = "safetyNo")
    private String safetyNo; //医保号

    @XmlElement(name = "icCardNo")
    private String icCardNo; //病人就诊卡号(患者一卡通唯一编号)

    @XmlElement(name = "patientName")
    private String patientName; //姓名

    @XmlElement(name = "patientSex")
    private String patientSex; //性别

    @XmlElement(name = "patientAge")
    private String patientAge; //年龄

    @XmlElement(name = "patientBirthDay")
    private String patientBirthDay; //出生日期

    @XmlElement(name = "identityCardNo")
    private String identityCardNo; //身份证号

    @XmlElement(name = "employerName")
    private String employerName; //工作单位名称

    @XmlElement(name = "contactAddress")
    private String contactAddress; //通讯地址

    @XmlElement(name = "telephone")
    private String telephone; //手机号码

    @XmlElement(name = "patientCountry")
    private String patientCountry; //国籍

    @XmlElement(name = "patientNation")
    private String patientNation; //名族

    @XmlElement(name = "bedNo")
    private String bedNo; //床号

    @XmlElement(name = "visitDeptCode")
    private String visitDeptCode; //就诊科室代码

    @XmlElement(name = "visitDeptName")
    private String visitDeptName; //就诊科室名称

    @XmlElement(name = "visitOperator")
    private String visitOperator; //就诊医生

    @XmlElement(name = "diagnoseCode")
    private String diagnoseCode; //诊断代码

    @XmlElement(name = "diagnoseName")
    private String diagnoseName; //诊断名称

    @XmlElement(name = "abstractHistory")
    private String abstractHistory; //病史

    @XmlElement(name = "clinicInfo")
    private String clinicInfo; //主诉

    @XmlElement(name = "sickSynptom")
    private String sickSynptom; //体征

    @XmlElementWrapper(name = "examItems")
    @XmlElement(name = "examItem")
    private List<ExamItem> examItems; //科室代码、科室名称

    public ReturnContent() {
        super();
    }

    public ReturnContent(String patientId, String visitNo, String visitType, String safetyNo, String icCardNo, String patientName, String patientSex, String patientAge, String patientBirthDay, String identityCardNo, String employerName, String contactAddress, String telephone, String patientCountry, String patientNation, String bedNo, String visitDeptCode, String visitDeptName, String visitOperator, String diagnoseCode, String diagnoseName, String abstractHistory, String clinicInfo, String sickSynptom, List<ExamItem> examItems) {
        this.patientId = patientId;
        this.visitNo = visitNo;
        this.visitType = visitType;
        this.safetyNo = safetyNo;
        this.icCardNo = icCardNo;
        this.patientName = patientName;
        this.patientSex = patientSex;
        this.patientAge = patientAge;
        this.patientBirthDay = patientBirthDay;
        this.identityCardNo = identityCardNo;
        this.employerName = employerName;
        this.contactAddress = contactAddress;
        this.telephone = telephone;
        this.patientCountry = patientCountry;
        this.patientNation = patientNation;
        this.bedNo = bedNo;
        this.visitDeptCode = visitDeptCode;
        this.visitDeptName = visitDeptName;
        this.visitOperator = visitOperator;
        this.diagnoseCode = diagnoseCode;
        this.diagnoseName = diagnoseName;
        this.abstractHistory = abstractHistory;
        this.clinicInfo = clinicInfo;
        this.sickSynptom = sickSynptom;
        this.examItems = examItems;
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

    public String getSafetyNo() {
        return safetyNo;
    }

    public void setSafetyNo(String safetyNo) {
        this.safetyNo = safetyNo;
    }

    public String getIcCardNo() {
        return icCardNo;
    }

    public void setIcCardNo(String icCardNo) {
        this.icCardNo = icCardNo;
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

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientBirthDay() {
        return patientBirthDay;
    }

    public void setPatientBirthDay(String patientBirthDay) {
        this.patientBirthDay = patientBirthDay;
    }

    public String getIdentityCardNo() {
        return identityCardNo;
    }

    public void setIdentityCardNo(String identityCardNo) {
        this.identityCardNo = identityCardNo;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPatientCountry() {
        return patientCountry;
    }

    public void setPatientCountry(String patientCountry) {
        this.patientCountry = patientCountry;
    }

    public String getPatientNation() {
        return patientNation;
    }

    public void setPatientNation(String patientNation) {
        this.patientNation = patientNation;
    }

    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
    }

    public String getVisitDeptCode() {
        return visitDeptCode;
    }

    public void setVisitDeptCode(String visitDeptCode) {
        this.visitDeptCode = visitDeptCode;
    }

    public String getVisitDeptName() {
        return visitDeptName;
    }

    public void setVisitDeptName(String visitDeptName) {
        this.visitDeptName = visitDeptName;
    }

    public String getVisitOperator() {
        return visitOperator;
    }

    public void setVisitOperator(String visitOperator) {
        this.visitOperator = visitOperator;
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

    public String getAbstractHistory() {
        return abstractHistory;
    }

    public void setAbstractHistory(String abstractHistory) {
        this.abstractHistory = abstractHistory;
    }

    public String getClinicInfo() {
        return clinicInfo;
    }

    public void setClinicInfo(String clinicInfo) {
        this.clinicInfo = clinicInfo;
    }

    public String getSickSynptom() {
        return sickSynptom;
    }

    public void setSickSynptom(String sickSynptom) {
        this.sickSynptom = sickSynptom;
    }

    public List<ExamItem> getExamItems() {
        return examItems;
    }

    public void setExamItems(List<ExamItem> examItems) {
        this.examItems = examItems;
    }

    @Override
    public String toString() {
        return "ReturnContent{" +
                "patientId='" + patientId + '\'' +
                ", visitNo='" + visitNo + '\'' +
                ", visitType='" + visitType + '\'' +
                ", safetyNo='" + safetyNo + '\'' +
                ", icCardNo='" + icCardNo + '\'' +
                ", patientName='" + patientName + '\'' +
                ", patientSex='" + patientSex + '\'' +
                ", patientAge='" + patientAge + '\'' +
                ", patientBirthDay='" + patientBirthDay + '\'' +
                ", identityCardNo='" + identityCardNo + '\'' +
                ", employerName='" + employerName + '\'' +
                ", contactAddress='" + contactAddress + '\'' +
                ", telephone='" + telephone + '\'' +
                ", patientCountry='" + patientCountry + '\'' +
                ", patientNation='" + patientNation + '\'' +
                ", bedNo='" + bedNo + '\'' +
                ", visitDeptCode='" + visitDeptCode + '\'' +
                ", visitDeptName='" + visitDeptName + '\'' +
                ", visitOperator='" + visitOperator + '\'' +
                ", diagnoseCode='" + diagnoseCode + '\'' +
                ", diagnoseName='" + diagnoseName + '\'' +
                ", abstractHistory='" + abstractHistory + '\'' +
                ", clinicInfo='" + clinicInfo + '\'' +
                ", sickSynptom='" + sickSynptom + '\'' +
                ", examItems=" + examItems +
                '}';
    }
}
