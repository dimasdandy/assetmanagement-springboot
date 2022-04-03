package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.Company;

public interface CompanyDao {

	List<Company> getAllCompanies() throws Exception;
	
	Company getById(String id) throws Exception;
	
	void add(Company company) throws Exception;

	void update(Company company) throws Exception;
	
	void delete(String id) throws Exception;
}
