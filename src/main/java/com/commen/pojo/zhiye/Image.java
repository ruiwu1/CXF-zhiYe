package com.commen.pojo.zhiye;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 图片
 */
@XmlRootElement(name="image")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"code","sub","typeCode","remark"})
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    @XmlAttribute(name = "code")
    private String code; //图像代码

    @XmlAttribute(name = "sub")
    private String sub; //图像序号

    @XmlAttribute(name = "typeCode")
    private String typeCode; //图像类型(1普通图像2dicom)

    @XmlAttribute(name = "remark")
    private String remark; //备注

    public Image() {
        super();
    }

    public Image(String code, String sub, String typeCode, String remark) {
        this.code = code;
        this.sub = sub;
        this.typeCode = typeCode;
        this.remark = remark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Image{" +
                "code='" + code + '\'' +
                ", sub='" + sub + '\'' +
                ", typeCode='" + typeCode + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
