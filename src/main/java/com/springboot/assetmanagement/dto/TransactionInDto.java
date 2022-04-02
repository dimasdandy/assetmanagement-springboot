package com.springboot.assetmanagement.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class TransactionInDto {

	private String id;
	private String code;
	private Date checkInDate;
	private TransactionOutDto transactionOut;
	private List<DetailTransactionInDto> detailTransactionIn;
	private String createdBy;
	private LocalDateTime createdDate;
	private String updatedBy;
	private LocalDateTime updatedDate;
	private Long version;
	private Boolean isActive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public TransactionOutDto getTransactionOut() {
		return transactionOut;
	}

	public void setTransactionOut(TransactionOutDto transactionOut) {
		this.transactionOut = transactionOut;
	}

	public List<DetailTransactionInDto> getDetailTransactionIn() {
		return detailTransactionIn;
	}

	public void setDetailTransactionIn(List<DetailTransactionInDto> detailTransactionIn) {
		this.detailTransactionIn = detailTransactionIn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
