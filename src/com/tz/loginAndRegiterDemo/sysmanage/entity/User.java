package com.tz.loginAndRegiterDemo.sysmanage.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2910624364547634819L;
	//序列化的作用：保证对象传输过程中唯一
	private Integer id;
	private String username;
	private String password;
	private String nikename;
	private String phoneNumber;
	private Timestamp createData;
	private Timestamp updateData;
	
	public User(){
		super();
	}
	public User(String username, String password, String nikename, String phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.nikename = nikename;
		this.phoneNumber = phoneNumber;
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, String nikename) {
		super();
		this.username = username;
		this.password = password;
		this.nikename = nikename;
	}
	public User(String username, String password, String nikename, String phoneNumber, Timestamp createData,
			Timestamp updateData) {
		super();
		this.username = username;
		this.password = password;
		this.nikename = nikename;
		this.phoneNumber = phoneNumber;
		this.createData = createData;
		this.updateData = updateData;
	}
	public User(Integer id, String username, String password, String nikename, String phoneNumber, Timestamp createData,
			Timestamp updateData) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nikename = nikename;
		this.phoneNumber = phoneNumber;
		this.createData = createData;
		this.updateData = updateData;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNikename() {
		return nikename;
	}
	public void setNikename(String nikename) {
		this.nikename = nikename;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Timestamp getCreateData() {
		return createData;
	}
	public void setCreateData(Timestamp createData) {
		this.createData = createData;
	}
	public Timestamp getUpdateData() {
		return updateData;
	}
	public void setUpdateData(Timestamp updateData) {
		this.updateData = updateData;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", nikename=" + nikename
				+ ", phoneNumber=" + phoneNumber + ", createData=" + createData + ", updateData=" + updateData + "]";
	}
}
