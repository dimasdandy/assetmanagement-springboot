package com.springboot.assetmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.springboot.assetmanagement.base.BaseEntity;

@Entity
@Table(name = "tbl_transactions_out", uniqueConstraints = 
@UniqueConstraint(columnNames = { "code" }))
public class TransactionOut extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "code")
	private String code;
	
	@JoinColumn(name = "id_employee", referencedColumnName = "id")
	@ManyToOne
	private Employee employee;
	
	@JoinColumn(name = "id_general_item", referencedColumnName = "id")
	@ManyToOne
	private Item item;
	
	@Column(name = "check_out_date")
	private Date checkOutDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
}
