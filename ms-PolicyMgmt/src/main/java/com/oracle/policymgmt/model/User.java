package com.oracle.policymgmt.model;

public class User {
	
	
	
	
	public String userid;
	
	
	public String password;
	
	
	public String tokenid;

	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTokenid() {
		return tokenid;
	}

	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}

	public User(String userid, String password, String tokenId) {
		this.userid = userid;
		this.password = password;
		this.tokenid=tokenId;
		
	}
	
	
		
}
