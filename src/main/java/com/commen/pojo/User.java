package com.commen.pojo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 返回员工标识
 * @author ruiwu
 */
@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"userName","staffName","employeNo"})
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "userName")
    private String userName;  //用户名
	@XmlElement(name = "staffName")
    private String staffName;  //姓名
	@XmlElement(name = "employeNo")
    private String employeNo;  //工作牌号
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getEmployeNo() {
		return employeNo;
	}

	public void setEmployeNo(String employeNo) {
		this.employeNo = employeNo;
	}

	public User() {
		super();
	}

	public User(String userName, String staffName, String employeNo) {
		super();
		this.userName = userName;
		this.staffName = staffName;
		this.employeNo = employeNo;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", staffName=" + staffName + ", employeNo=" + employeNo + "]";
	}
    
}
