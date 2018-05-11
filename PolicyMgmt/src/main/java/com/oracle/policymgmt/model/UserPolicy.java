package com.oracle.policymgmt.model;



import java.math.BigDecimal;
import java.util.Date;



public class UserPolicy {



	private String id;
	
	private String user_policy_id;
	
	private String userId;
	
	private String productId;
	
	private String sumAssured;
	
	private String maturityDate;
	
	private String premiumFrequency;
	
	private String premiumAmt;
	
	
	private String purchaseDate;
	
	private String policyStatus;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_policy_id() {
		return user_policy_id;
	}

	public void setUser_policy_id(String user_policy_id) {
		this.user_policy_id = user_policy_id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getSumAssured() {
		return sumAssured;
	}

	public void setSumAssured(String sumAssured) {
		this.sumAssured = sumAssured;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getPremiumFrequency() {
		return premiumFrequency;
	}

	public void setPremiumFrequency(String premiumFrequency) {
		this.premiumFrequency = premiumFrequency;
	}

	public String getPremiumAmt() {
		return premiumAmt;
	}

	public void setPremiumAmt(String premiumAmt) {
		this.premiumAmt = premiumAmt;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}
	
}
	