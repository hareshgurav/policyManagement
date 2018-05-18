package com.oracle.policymgmt.model;

import org.springframework.data.annotation.Id;




public class Payment {

	@Id
	private String id;
	private String transid;
	private String userid;
	private String userpolicyid;
	private String accountno;
	private String amount;
	private String bankname;
	private String paymentstatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTransid() {
		return transid;
	}
	public void setTransid(String transid) {
		this.transid = transid;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpolicyid() {
		return userpolicyid;
	}
	public void setUserpolicyid(String userpolicyid) {
		this.userpolicyid = userpolicyid;
	}
	public String getAccountno() {
		return accountno;
	}
	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	@Override
	public String toString() {
		return "Payment [transid=" + transid + ", userid=" + userid + ", userpolicyid=" + userpolicyid + ", accountno="
				+ accountno + ", amount=" + amount + ", bankname=" + bankname + ", paymentstatus=" + paymentstatus
				+ "]";
	}
	
	
	
	
}
