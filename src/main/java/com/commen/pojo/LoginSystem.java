package com.commen.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 业务系统有几个登录系统作为一个字典在集成平台中进行维护，而且集成平台中登录系统的代码与在业务系统中该登录系统的代码保持一致。
 * @author ruiwu
 *
 */
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"code","name"})
public class LoginSystem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "code")
	private String code; //登录系统编码
	@XmlElement(name = "name")
	private String name; //登录系统名称

	public LoginSystem() {
		super();
	}

	public LoginSystem(String code, String name) {
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
		return "LoginSystem [code=" + code + ", name=" + name + "]";
	}
	
}
