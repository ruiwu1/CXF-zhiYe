package com.commen.pojo.zhiye;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 申请单
 */
@XmlRootElement(name="applyNo")
@XmlAccessorType(XmlAccessType.FIELD)
public class ApplyNo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String applyNo; //申请单号

    public ApplyNo() {
        super();
    }

    public ApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    public String getApplyNo() {
        return applyNo;
    }

    public void setApplyNo(String applyNo) {
        this.applyNo = applyNo;
    }

    @Override
    public String toString() {
        return "ApplyNo{" +
                "applyNo='" + applyNo + '\'' +
                '}';
    }
}
