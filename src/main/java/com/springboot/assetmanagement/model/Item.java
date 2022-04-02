package com.springboot.assetmanagement.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.springboot.assetmanagement.base.BaseEntity;

@Entity
@Table(name = "tbl_items")
public class Item extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "id_item_type", referencedColumnName = "id")
	@ManyToOne
	private ItemType itemType;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "serial")
	private String serial;
	
	@Column(name = "price")
	private BigDecimal price;

	public ItemType getItemType() {
		return itemType;
	}

	public void setItemType(ItemType itemType) {
		this.itemType = itemType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
