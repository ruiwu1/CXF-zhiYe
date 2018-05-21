package com.commen.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 登录系统通过调用统一登录平台的令牌验证服务，验证登录数据的正确性与有效性。
 * @author ruiwu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@XmlType(propOrder={"tokenCode","systemCode","computerName","userName","loginSystemCode","roleCode","deptCode"})
public class MsgBody implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "tokenCode")
	private String tokenCode; //令牌
	@XmlElement(name = "systemCode")
	private String systemCode; //业务系统代码
	@XmlElement(name = "computerName")
	private String computerName; //计算机名称
	@XmlElement(name = "userName")
	private String userName; //登录用户名
	@XmlElement(name = "loginSystemCode")
	private String loginSystemCode; //登录系统代码
	@XmlElement(name = "roleCode")
	private String roleCode; //角色代码
	@XmlElement(name = "deptCode")
	private String deptCode; //科室代码
	
	public MsgBody() {
		super();
	}
	
	public MsgBody(String tokenCode, String systemCode, String computerName, String userName, String loginSystemCode,
			String roleCode, String deptCode) {
		super();
		this.tokenCode = tokenCode;
		this.systemCode = systemCode;
		this.computerName = computerName;
		this.userName = userName;
		this.loginSystemCode = loginSystemCode;
		this.roleCode = roleCode;
		this.deptCode = deptCode;
	}
	
	public String getTokenCode() {
		return tokenCode;
	}
	
	public void setTokenCode(String tokenCode) {
		this.tokenCode = tokenCode;
	}
	
	public String getSystemCode() {
		return systemCode;
	}
	
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	
	public String getComputerName() {
		return computerName;
	}
	
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getLoginSystemCode() {
		return loginSystemCode;
	}
	
	public void setLoginSystemCode(String loginSystemCode) {
		this.loginSystemCode = loginSystemCode;
	}
	
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	public String getDeptCode() {
		return deptCode;
	}
	
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
	
	@Override
	public String toString() {
		return "MsgBody [tokenCode=" + tokenCode + ", systemCode=" + systemCode + ", computerName=" + computerName
				+ ", userName=" + userName + ", loginSystemCode=" + loginSystemCode + ", roleCode=" + roleCode
				+ ", deptCode=" + deptCode + "]";
	}

}
