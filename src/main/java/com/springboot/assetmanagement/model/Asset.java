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
@Table(name = "tbl_assets", uniqueConstraints = 
@UniqueConstraint(columnNames = { "code" }))
public class Asset extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "code")
	private String code;
	
	@JoinColumn(name = "id_item", referencedColumnName = "id")
	@ManyToOne
	private Item item;
	
	@JoinColumn(name = "id_status_asset", referencedColumnName = "id")
	@ManyToOne
	private StatusAsset statusAsset;
	
	@JoinColumn(name = "id_company", referencedColumnName = "id")
	@ManyToOne
	private Company company;
	
	@JoinColumn(name = "id_invoice", referencedColumnName = "id")
	@ManyToOne
	private Invoice invoice;
	
	@Column(name = "expired_date")
	private Date expiredDate;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public StatusAsset getStatusAsset() {
		return statusAsset;
	}

	public void setStatusAsset(StatusAsset statusAsset) {
		this.statusAsset = statusAsset;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Date getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

}
