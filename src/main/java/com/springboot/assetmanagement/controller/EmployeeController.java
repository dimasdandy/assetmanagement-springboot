package com.springboot.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assetmanagement.model.Employee;
import com.springboot.assetmanagement.service.EmployeeService;

@RestController
@RequestMapping(value = "api/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "employees")
	public ResponseEntity<?> getAllEmployees() {
		try {
			return ResponseEntity.ok(employeeService.getAllEmployees());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "employee/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(employeeService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping(value = "employee")
	public ResponseEntity<?> add(@RequestBody Employee employee) throws Exception {
		try {
			employeeService.add(employee);
			return ResponseEntity.ok("employee has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "employee")
	public ResponseEntity<?> update(@RequestBody Employee employee) throws Exception {
		try {
			employeeService.update(employee);
			return ResponseEntity.ok("employee has been updated.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "employee/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			employeeService.delete(id);
			return ResponseEntity.ok("employee has been deleted.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
