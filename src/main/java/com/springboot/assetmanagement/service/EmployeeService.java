package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees() throws Exception;

	Employee getById(String id) throws Exception;

}
