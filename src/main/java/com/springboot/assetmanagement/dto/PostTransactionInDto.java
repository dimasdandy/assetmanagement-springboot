package com.springboot.assetmanagement.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class PostTransactionInDto {

	private String code;
	private String transactionOutId;
	private Date checkInDate;
	private List<PostDetailTransactionInDto> detailTransactionIn;
	private String createdBy;
	private LocalDateTime createdDate;
	private String updatedBy;
	private LocalDateTime updatedDate;
	private Long version;
	private Boolean isActive;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTransactionOutId() {
		return transactionOutId;
	}

	public void setTransactionOutId(String transactionOutId) {
		this.transactionOutId = transactionOutId;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public List<PostDetailTransactionInDto> getDetailTransactionIn() {
		return detailTransactionIn;
	}

	public void setDetailTransactionIn(List<PostDetailTransactionInDto> detailTransactionIn) {
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
