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

import com.springboot.assetmanagement.model.Company;
import com.springboot.assetmanagement.service.CompanyService;

@RestController
@RequestMapping(value = "api/")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping(value = "companies")
	public ResponseEntity<?> getAllCompany() {
		try {
			return ResponseEntity.ok(companyService.getAllCompanies());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "company/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(companyService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping(value = "company")
	public ResponseEntity<?> add(@RequestBody Company company) throws Exception {
		try {
			companyService.add(company);
			return ResponseEntity.ok("company has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "company")
	public ResponseEntity<?> update(@RequestBody Company company) throws Exception {
		try {
			companyService.update(company);
			return ResponseEntity.ok("company has been updated.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "company/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			companyService.delete(id);
			return ResponseEntity.ok("company has been deleted.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
