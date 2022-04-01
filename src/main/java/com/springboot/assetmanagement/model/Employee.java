package com.springboot.assetmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.springboot.assetmanagement.base.BaseEntity;

@Entity
@Table(name = "tbl_employees", uniqueConstraints = 
@UniqueConstraint(columnNames = { "email" }))
public class Employee extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "id_company", referencedColumnName = "id")
	@ManyToOne
	private Company company;
	
	@Column(name = "nip")
	private String nip;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name = "department")
	private String department;

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
}
