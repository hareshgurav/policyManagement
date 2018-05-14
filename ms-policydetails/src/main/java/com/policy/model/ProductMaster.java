package com.policy.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="productmaster")
public class ProductMaster {

	
	private String id;
	private  Integer productid;
	private String productname;
	private Integer productterm;
	private String producttype;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public Integer getProductterm() {
		return productterm;
	}
	public void setProductterm(Integer productterm) {
		this.productterm = productterm;
	}
	public String getProducttype() {
		return producttype;
	}
	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}
	
	
	
	
}
