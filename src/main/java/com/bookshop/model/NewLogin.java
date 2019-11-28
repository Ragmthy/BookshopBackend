package com.bookshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoginInfo")
public class NewLogin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loginId;
	private String email;
	private String loginTime;
	private String logoutTime;
	
	//Constructors
	
	public NewLogin(long loginId, String email, String loginTime, String logoutTime) {
		super();
		this.loginId = loginId;
		this.email = email;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}
	
	public NewLogin(long loginId) {
		super();
		this.loginId = loginId;
	}
	
	public NewLogin(String email, String loginTime, String logoutTime) {
		super();
		this.email = email;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}

	public NewLogin() {
		super();
	}

	public long getLoginId() {
		return loginId;
	}

	public void setLoginId(long loginId) {
		this.loginId = loginId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	
	
	
	

}
