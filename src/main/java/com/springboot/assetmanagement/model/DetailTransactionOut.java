package com.springboot.assetmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.springboot.assetmanagement.base.BaseEntity;

@Entity
@Table(name = "tbl_detail_transactions_out")
public class DetailTransactionOut extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "id_transaction_out", referencedColumnName = "id")
	@ManyToOne
	private TransactionOut transactionOut;
	
	@JoinColumn(name = "id_asset", referencedColumnName = "id")
	@ManyToOne
	private Asset asset;

	@Column(name = "due_date")
	private Date dueDate;

	public TransactionOut getTransactionOut() {
		return transactionOut;
	}

	public void setTransactionOut(TransactionOut transactionOut) {
		this.transactionOut = transactionOut;
	}

	public Asset getAsset() {
		return asset;
	}

	public void setAsset(Asset asset) {
		this.asset = asset;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
}
