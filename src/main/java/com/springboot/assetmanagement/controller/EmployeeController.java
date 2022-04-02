package com.springboot.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assetmanagement.dao.EmployeeDao;

@RestController
@RequestMapping(value = "api/")
public class EmployeeController {

	@Autowired
	private EmployeeDao employeeDao;
	
	@GetMapping(value = "employees")
	public ResponseEntity<?> getAllEmployees() {
		try {
			return ResponseEntity.ok(employeeDao.getAllEmployees());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "employee/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(employeeDao.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
