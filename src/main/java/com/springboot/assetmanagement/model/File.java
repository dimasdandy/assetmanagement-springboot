package com.springboot.assetmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.springboot.assetmanagement.base.BaseEntity;

@Entity
@Table(name = "tbl_files")
public class File extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "data_file")
	private byte[] file;

	@Column(name = "extention")
	private String extention;

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getExtention() {
		return extention;
	}

	public void setExtention(String extention) {
		this.extention = extention;
	}
	
}	
