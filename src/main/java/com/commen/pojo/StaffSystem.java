package com.commen.pojo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 获取员工有权限登录的系统信息
 * @author ruiwu
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@XmlType(propOrder={"staffKey","userName","customSystemCode","loginSystems"})
public class StaffSystem implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "staffKey")
	private String staffKey; //员工标识
	
	@XmlElement(name = "userName")
	private String userName; //用户名
	
	@XmlElement(name = "customSystemCode")
	private String customSystemCode; //业务代码
	
	@XmlElementWrapper(name = "loginSystems") 
	@XmlElement(name = "loginSystem")
	private List<LoginSystem> loginSystems; //登录系统编码和业务

	public StaffSystem() {
		super();
	}

	public StaffSystem(String staffKey, String userName, String customSystemCode, List<LoginSystem> loginSystems) {
		super();
		this.staffKey = staffKey;
		this.userName = userName;
		this.customSystemCode = customSystemCode;
		this.loginSystems = loginSystems;
	}

	public String getStaffKey() {
		return staffKey;
	}

	public void setStaffKey(String staffKey) {
		this.staffKey = staffKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCustomSystemCode() {
		return customSystemCode;
	}

	public void setCustomSystemCode(String customSystemCode) {
		this.customSystemCode = customSystemCode;
	}

	public List<LoginSystem> getLoginSystems() {
		return loginSystems;
	}

	public void setLoginSystems(List<LoginSystem> loginSystems) {
		this.loginSystems = loginSystems;
	}

	@Override
	public String toString() {
		return "Xmlparam [staffKey=" + staffKey + ", userName=" + userName + ", customSystemCode=" + customSystemCode
				+ ", loginSystems=" + loginSystems + "]";
	}
	
	
}
