package com.commen.pojo.zhiye;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * HIS或体检申请单号-*单据状态
 */
@XmlRootElement(name="applyInfo")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"applyNo","applyStatus"})
public class ApplyInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlElement(name = "applyNo")
    private String applyNo; //HIS或体检申请单号

    @XmlElement(name = "applyStatus")
    private String applyStatus; //单据状态

    public ApplyInfo() {
        super();
    }

    public ApplyInfo(String applyNo, String applyStatus) {
        this.applyNo = applyNo;
        this.applyStatus = applyStatus;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    @Override
    public String toString() {
        return "ApplyInfo{" +
                "applyNo='" + applyNo + '\'' +
                ", applyStatus='" + applyStatus + '\'' +
                '}';
    }
}
