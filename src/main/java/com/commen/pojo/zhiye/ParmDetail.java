package com.commen.pojo.zhiye;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 左户前后径，室间隔或左室后壁厚，主动脉根部内景，左室前后径，射血分数
 */
@XmlRootElement(name="parmDetail")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"parmItemNo","parmEngName","parmChiName","parmValue","parmSortNo","remark"})
public class ParmDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "parmItemNo")
    private String parmItemNo; //参数代码

    @XmlAttribute(name = "parmEngName")
    private String parmEngName; //参数英文名称

    @XmlAttribute(name = "parmChiName")
    private String parmChiName; //参数中文名称

    @XmlAttribute(name = "parmValue")
    private String parmValue; //参数值

    @XmlAttribute(name = "parmSortNo")
    private String parmSortNo; //排序号

    @XmlAttribute(name = "remark")
    private String remark; //备注

    public ParmDetail() {
        super();
    }

    public ParmDetail(String parmItemNo, String parmEngName, String parmChiName, String parmValue, String parmSortNo, String remark) {
        this.parmItemNo = parmItemNo;
        this.parmEngName = parmEngName;
        this.parmChiName = parmChiName;
        this.parmValue = parmValue;
        this.parmSortNo = parmSortNo;
        this.remark = remark;
    }

    public String getParmItemNo() {
        return parmItemNo;
    }

    public void setParmItemNo(String parmItemNo) {
        this.parmItemNo = parmItemNo;
    }

    public String getParmEngName() {
        return parmEngName;
    }

    public void setParmEngName(String parmEngName) {
        this.parmEngName = parmEngName;
    }

    public String getParmChiName() {
        return parmChiName;
    }

    public void setParmChiName(String parmChiName) {
        this.parmChiName = parmChiName;
    }

    public String getParmValue() {
        return parmValue;
    }

    public void setParmValue(String parmValue) {
        this.parmValue = parmValue;
    }

    public String getParmSortNo() {
        return parmSortNo;
    }

    public void setParmSortNo(String parmSortNo) {
        this.parmSortNo = parmSortNo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ParmDetail{" +
                "parmItemNo='" + parmItemNo + '\'' +
                ", parmEngName='" + parmEngName + '\'' +
                ", parmChiName='" + parmChiName + '\'' +
                ", parmValue='" + parmValue + '\'' +
                ", parmSortNo='" + parmSortNo + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
