package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

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

	@Override
	@Transactional
	public void add(Company company) throws Exception {
		company.setCode(company.getCode());
		company.setName(company.getName());
		company.setCreatedBy("admin");
		company.setCreatedDate(LocalDateTime.now());
		company.setVersion(0L);
		company.setIsActive(true);
		companyDao.add(company);
	}

	@Override
	@Transactional
	public void update(Company company) throws Exception {
		Company companies = getById(company.getId());
		if (companies.getId() == null || companies.getId().isEmpty()) {
			throw new ValidationException("id cannot be null.");
		}
		company.setCode(company.getCode());
		company.setName(company.getName());
		company.setCreatedBy(companies.getCreatedBy());
		company.setCreatedDate(companies.getCreatedDate());
		company.setUpdatedBy("admin");
		company.setUpdatedDate(LocalDateTime.now());
		company.setVersion(company.getVersion()+1L);
		companyDao.update(company);
	}

	@Override
	@Transactional
	public void delete(String id) throws Exception {
		Company company = new Company();
		company.setId(id);
		companyDao.delete(id);		
	}

}
