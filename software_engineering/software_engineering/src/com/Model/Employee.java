package com.Model;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {

	// Fields

	private Integer employeeId;
	private Department department;
	private String email;
	private String phoneNumber;
	private String hireDate;

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** minimal constructor */
	public Employee(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/** full constructor */
	public Employee(Integer employeeId, Department department, String email,
			String phoneNumber, String hireDate) {
		this.employeeId = employeeId;
		this.department = department;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
	}

	// Property accessors

	public Integer getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

}