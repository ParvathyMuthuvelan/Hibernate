package com.pojo;

import java.io.Serializable;

public class Emp implements Serializable{

	private int empId;
	private String empName;
	private String dept;
	private double empSal;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getEmpSal() {
		return empSal;
	}
	public void setEmpSal(double empSal) {
		this.empSal = empSal;
	}
	@Override
	public String toString() {
		return String.format("Emp [empId=%s, empName=%s, dept=%s, empSal=%s]", empId, empName, dept, empSal);
	}
	
	
	
	
}
