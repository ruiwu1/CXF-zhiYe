package com.commen.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 科室代码、科室名称使用集成平台中统一的科室字典中的代码和名称。
 * @author ruiwu
 *
 */
@XmlRootElement(name="dept")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"code","name"})
public class Dept implements Serializable{

	private static final long serialVersionUID = 1L;
	@XmlElement(name = "code")
	private String code; //登录系统编码
	@XmlElement(name = "name")
	private String name; //登录系统名称

	public Dept() {
		super();
	}

	public Dept(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dept [code=" + code + ", name=" + name + "]";
	}

}
