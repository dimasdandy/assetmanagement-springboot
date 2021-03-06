package com.springboot.assetmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.model.Company;

@Repository
public class CompanyDaoImpl extends BaseDaoImpl implements CompanyDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> getAllCompanies() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT company.* ")
		.append("FROM tbl_companies company ") 
		.append("WHERE company.is_active = true ");
		
		List<Company> list = em.createNativeQuery(sb.toString(), Company.class)
				.getResultList();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Company getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT company.* ")
		.append("FROM tbl_companies company ") 
		.append("WHERE company.id = (:id)\\:\\:text ") 
		.append("AND company.is_active = true ");
		
		List<Company> list = em.createNativeQuery(sb.toString(), Company.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	@Override
	public void add(Company company) throws Exception {
		em.persist(company);
	}

	@Override
	public void update(Company company) throws Exception {
		em.merge(company);
	}

	@Override
	public void delete(String id) throws Exception {
		String sql = "DELETE FROM tbl_companies where id = :id";
		em.createNativeQuery(sql).setParameter("id", id).executeUpdate();
	}

	
}
