package com.springboot.assetmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.model.Employee;

@Repository
public class EmployeeDaoImpl extends BaseDaoImpl implements EmployeeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAllEmployees() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT employee.* ")
		.append("FROM tbl_employees employee ") 
		.append("WHERE employee.is_active = true ");
		
		List<Employee> list = em.createNativeQuery(sb.toString(), Employee.class)
				.getResultList();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Employee getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT employee.* ")
		.append("FROM tbl_employees employee ") 
		.append("WHERE employee.id = (:id)\\:\\:text ") 
		.append("AND employee.is_active = true ");
		
		List<Employee> list = em.createNativeQuery(sb.toString(), Employee.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	@Override
	public void add(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		em.persist(employee);
	}

	@Override
	public void update(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		em.merge(employee);
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tbl_employees where id = :id";
		em.createNativeQuery(sql).setParameter("id", id).executeUpdate();
	}

	
}
