package com.commen.pojo.zhiye;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 * 获取检查申请单信息
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@XmlType(propOrder={"applyNo","visitType","returnContents"})
public class ExamApplyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "applyNo")
    private String applyNo; //申请单号

    @XmlElement(name = "visitType")
    private String visitType; //就诊类型1门急诊2住院 3体检

    @XmlElementWrapper(name = "returnContents")
    @XmlElement(name = "returnContent")
    private List<ReturnContent> returnContents; //科室代码、科室名称

    public ExamApplyInfo() {
        super();
    }

    public ExamApplyInfo(String applyNo, String visitType, List<ReturnContent> returnContents) {
        this.applyNo = applyNo;
        this.visitType = visitType;
        this.returnContents = returnContents;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public List<ReturnContent> getReturnContents() {
        return returnContents;
    }

    public void setReturnContents(List<ReturnContent> returnContents) {
        this.returnContents = returnContents;
    }

    @Override
    public String toString() {
        return "ExamApplyInfo{" +
                "applyNo='" + applyNo + '\'' +
                ", visitType='" + visitType + '\'' +
                ", returnContents=" + returnContents +
                '}';
    }
}
