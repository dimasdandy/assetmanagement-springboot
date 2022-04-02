package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.Company;

public interface CompanyDao {

	List<Company> getAllCompanies() throws Exception;
	
	Company getById(String id) throws Exception;
	
}
