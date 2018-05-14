package com.policy.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userpolicy")
public class UserPolicy {

	private String id;
	private String userpolicyid;
	private Integer userid;
	private Integer productid;
	private Integer sumassured;
	private String maturitydate;
	private String premiumfrequency;
	private Integer premiumamt;
	private String purchasedate;
	private String policyStatus;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserpolicyid() {
		return userpolicyid;
	}
	public void setUserpolicyid(String userpolicyid) {
		this.userpolicyid = userpolicyid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getSumassured() {
		return sumassured;
	}
	public void setSumassured(Integer sumassured) {
		this.sumassured = sumassured;
	}
	public String getMaturitydate() {
		return maturitydate;
	}
	public void setMaturitydate(String maturitydate) {
		this.maturitydate = maturitydate;
	}
	public String getPremiumfrequency() {
		return premiumfrequency;
	}
	public void setPremiumfrequency(String premiumfrequency) {
		this.premiumfrequency = premiumfrequency;
	}
	public Integer getPremiumamt() {
		return premiumamt;
	}
	public void setPremiumamt(Integer premiumamt) {
		this.premiumamt = premiumamt;
	}
	public String getPurchasedate() {
		return purchasedate;
	}
	public void setPurchasedate(String purchasedate) {
		this.purchasedate = purchasedate;
	}
	public String getPolicyStatus() {
		return policyStatus;
	}
	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
	
	
}
