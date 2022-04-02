package com.springboot.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.EmployeeDao;
import com.springboot.assetmanagement.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee getById(String id) throws Exception {
		return employeeDao.getById(id);
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		return employeeDao.getAllEmployees();
	}

}
