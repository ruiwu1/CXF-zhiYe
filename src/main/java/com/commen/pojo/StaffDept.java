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
 * 获取员工有权限登录的科室信息
 * @author ruiwu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@XmlType(propOrder={"customSystemCode","loginSystemCode","staffKey","userName","depts"})
public class StaffDept implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "customSystemCode")
	private String customSystemCode; //业务系统代码
	
	@XmlElement(name = "loginSystemCode")
	private String loginSystemCode; //登录系统代码
	
	@XmlElement(name = "staffKey")
	private String staffKey; //员工标识
	
	@XmlElement(name = "userName")
	private String userName; //用户名
	
	@XmlElementWrapper(name = "depts") 
	@XmlElement(name = "dept")
	private List<Dept> depts; //科室代码、科室名称

	public StaffDept() {
		super();
	}

	public StaffDept(String customSystemCode, String loginSystemCode, String staffKey, String userName,
			List<Dept> depts) {
		super();
		this.customSystemCode = customSystemCode;
		this.loginSystemCode = loginSystemCode;
		this.staffKey = staffKey;
		this.userName = userName;
		this.depts = depts;
	}

	public String getCustomSystemCode() {
		return customSystemCode;
	}

	public void setCustomSystemCode(String customSystemCode) {
		this.customSystemCode = customSystemCode;
	}

	public String getLoginSystemCode() {
		return loginSystemCode;
	}

	public void setLoginSystemCode(String loginSystemCode) {
		this.loginSystemCode = loginSystemCode;
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

	public List<Dept> getDepts() {
		return depts;
	}

	public void setDepts(List<Dept> depts) {
		this.depts = depts;
	}

	@Override
	public String toString() {
		return "StaffDept [customSystemCode=" + customSystemCode + ", loginSystemCode=" + loginSystemCode
				+ ", staffKey=" + staffKey + ", userName=" + userName + ", depts=" + depts + "]";
	}

}
