package com.springboot.assetmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.springboot.assetmanagement.base.BaseEntity;

@Entity
@Table(name = "tbl_transactions_in", uniqueConstraints = 
@UniqueConstraint(columnNames = { "code" }))
public class TransactionIn extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "code")
	private String code;
	
	@JoinColumn(name = "id_transaction_out", referencedColumnName = "id")
	@OneToOne
	private TransactionOut transactionOut;

	@Column(name = "check_in_date")
	private Date checkInDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TransactionOut getTransactionOut() {
		return transactionOut;
	}

	public void setTransactionOut(TransactionOut transactionOut) {
		this.transactionOut = transactionOut;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	
}
