package com.oracle.policymgmt.model;

public class Employee {
	
	private int empId;
	private String name;
	private String role;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	Employee(int empId, String name, String role)
	
	{
		this.empId=empId;
		this.name=name;
		this.role=role;
	}

}
