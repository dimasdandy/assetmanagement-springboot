package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.EmployeeDao;
import com.springboot.assetmanagement.model.Company;
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

	@Override
	@Transactional
	public void add(Employee employee) throws Exception {
		Company company = new Company();
		company.setId(employee.getCompany().getId());
		employee.setCompany(company);
		
		employee.setNip(employee.getNip());
		employee.setEmail(employee.getEmail());
		employee.setFullName(employee.getFullName());
		employee.setPhoneNo(employee.getPhoneNo());
		employee.setDepartment(employee.getDepartment());
		employee.setCreatedBy("admin");
		employee.setCreatedDate(LocalDateTime.now());
		employee.setVersion(0L);
		employee.setIsActive(true);
		employeeDao.add(employee);
	}

	@Override
	@Transactional
	public void update(Employee employee) throws Exception {
		Employee employees = getById(employee.getId());
		if (employees.getId() == null || employees.getId().isEmpty()) {
			throw new ValidationException("id cannot be null.");
		}		
		
		Company company = new Company();
		company.setId(employee.getCompany().getId());
		employee.setCompany(company);
		
		employee.setNip(employee.getNip());
		employee.setEmail(employee.getEmail());
		employee.setFullName(employee.getFullName());
		employee.setPhoneNo(employee.getPhoneNo());
		employee.setDepartment(employee.getDepartment());
		employee.setCreatedBy(employees.getCreatedBy());
		employee.setCreatedDate(employees.getCreatedDate());
		employee.setUpdatedBy("admin");
		employee.setUpdatedDate(LocalDateTime.now());
		employee.setVersion(employee.getVersion()+1L);
		employeeDao.update(employee);
	}

	@Override
	@Transactional
	public void delete(String id) throws Exception {
		Employee employee = new Employee();
		employee.setId(id);
		employeeDao.delete(id);
	}

}
