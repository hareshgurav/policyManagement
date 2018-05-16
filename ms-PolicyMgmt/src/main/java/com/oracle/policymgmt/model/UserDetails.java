package com.oracle.policymgmt.model;

public class UserDetails {

	private String userId;
	private String name;
	private String mobileNo;
	private String address;
	private String dob;
	private String emailId;
	private String smoker;
	private String drinker;
	private String password;
	private String maritalStatus;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getSmoker() {
		return smoker;
	}

	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}

	public String getDrinker() {
		return drinker;
	}

	public void setDrinker(String drinker) {
		this.drinker = drinker;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	UserDetails(String userId,String name, String mobileNo,	 String  address,
	 String dob,
	 String emailId,
	 String smoker,
	 String drinker)
	{
	this.userId=userId;
	this.name=name;
	this.mobileNo=mobileNo;
	this.address=address;
	this.dob=dob;
	this.emailId=emailId;
	this.smoker=smoker;
	this.drinker=drinker;
	}

	public UserDetails() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
