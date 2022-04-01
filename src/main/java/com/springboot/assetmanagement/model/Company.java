package com.springboot.assetmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.springboot.assetmanagement.base.BaseEntity;

@Entity
@Table(name = "tbl_companies", uniqueConstraints = 
@UniqueConstraint(columnNames = { "code" }))
public class Company extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "code")
	private String code;

	@Column(name = "name")
	private String name;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
