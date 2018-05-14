package com.policy.model;

public class PaymentDTO {
	
	private String id;
	private Integer transid;
	private Integer userid;
	private String userpolicyid;
	private Integer accountno;
	private Integer amount;
	private String bankname;
	private String paymentstatus;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getTransid() {
		return transid;
	}
	public void setTransid(Integer transid) {
		this.transid = transid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUserpolicyid() {
		return userpolicyid;
	}
	public void setUserpolicyid(String userpolicyid) {
		this.userpolicyid = userpolicyid;
	}
	public Integer getAccountno() {
		return accountno;
	}
	public void setAccountno(Integer accountno) {
		this.accountno = accountno;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
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
	
	
	

}
