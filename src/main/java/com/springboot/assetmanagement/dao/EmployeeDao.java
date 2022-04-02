package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees() throws Exception;
	
	Employee getById(String id) throws Exception;
	
}
