package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.Company;

public interface CompanyService {

	List<Company> getAllCompanies() throws Exception;

	Company getById(String id) throws Exception;

}
