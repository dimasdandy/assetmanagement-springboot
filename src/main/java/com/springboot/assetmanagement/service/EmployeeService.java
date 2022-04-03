package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees() throws Exception;

	Employee getById(String id) throws Exception;
	
	void add(Employee employee) throws Exception;

	void update(Employee employee) throws Exception;
	
	void delete(String id) throws Exception;

}
