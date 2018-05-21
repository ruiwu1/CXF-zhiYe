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
 * 员工表示类--获取员工对应的用户信息。
 * @author ruiwu
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "root")
@XmlType(propOrder={"staffKey","users"})
public class StaffKey implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "staffKey")
	private String staffKey;
	
	@XmlElementWrapper(name = "users") 
	@XmlElement(name = "user")
	private List<User> users;

	public StaffKey() {
		super();
	}

	public StaffKey(String staffKey, List<User> users) {
		super();
		this.staffKey = staffKey;
		this.users = users;
	}

	public String getStaffKey() {
		return staffKey;
	}

	public void setStaffKey(String staffKey) {
		this.staffKey = staffKey;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "StaffKey [staffKey=" + staffKey + ", users=" + users + "]";
	}
	

}
