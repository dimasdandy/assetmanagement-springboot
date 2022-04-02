package com.springboot.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.CompanyDao;
import com.springboot.assetmanagement.model.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao companyDao;

	@Override
	public Company getById(String id) throws Exception {
		return companyDao.getById(id);
	}

	@Override
	public List<Company> getAllCompanies() throws Exception {
		return companyDao.getAllCompanies();
	}

}
