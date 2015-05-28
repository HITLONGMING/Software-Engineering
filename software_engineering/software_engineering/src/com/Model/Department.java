package com.Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Department entity. @author MyEclipse Persistence Tools
 */

public class Department implements java.io.Serializable {

	// Fields

	private Integer departmentId;
	private String departmentTitle;
	private String location;
	private Set employees = new HashSet(0);

	// Constructors

	/** default constructor */
	public Department() {
	}

	/** minimal constructor */
	public Department(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/** full constructor */
	public Department(Integer departmentId, String departmentTitle,
			String location/*, Set employees*/) {
		this.departmentId = departmentId;
		this.departmentTitle = departmentTitle;
		this.location = location;
		//this.employees = employees;
	}

	// Property accessors

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentTitle() {
		return this.departmentTitle;
	}

	public void setDepartmentTitle(String departmentTitle) {
		this.departmentTitle = departmentTitle;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

}