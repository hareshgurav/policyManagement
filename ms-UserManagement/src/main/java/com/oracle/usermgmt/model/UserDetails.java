package com.oracle.usermgmt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="userdetails")
public class UserDetails {
	@Id
	private String _id;
	@Field("userid")
	private String userId;
	@Field("name")
	private String name;
	@Field("mobile")
	private String mobileNo;
	@Field("address")
	private String  address;
	@Field("dob")
	private String dob;
	@Field("emailid")
	private String emailId;
	@Field("smoker")
	private String smoker;
	@Field("drinker")
	private String drinker;
/*	@Field("password")*/
	private String password;
	@Field("maritialstatus")
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

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}	
	
}
