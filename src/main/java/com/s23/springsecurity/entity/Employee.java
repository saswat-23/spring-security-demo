package com.s23.springsecurity.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	String empId;
	String empName;
	String password;
	String active;
	Date creationDt;
	Date updateDt;
	
	public Employee() {	}
	
	public Employee(String empId, String empName, String password, String active, Date creationDt, Date updateDt) {
		this.empId = empId;
		this.empName = empName;
		this.password = password;
		this.active = active;
		this.creationDt = creationDt;
		this.updateDt = updateDt;
	}
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Date getCreationDt() {
		return creationDt;
	}
	public void setCreationDt(Date creationDt) {
		this.creationDt = creationDt;
	}
	public Date getUpdateDt() {
		return updateDt;
	}
	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", password=" + password + ", active=" + active
				+ ", creationDt=" + creationDt + ", updateDt=" + updateDt + "]";
	}
	
	
}
