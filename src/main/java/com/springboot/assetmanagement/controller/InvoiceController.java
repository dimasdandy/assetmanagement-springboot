package com.springboot.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assetmanagement.service.InvoiceService;

@RestController
@RequestMapping(value = "api/")
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	@GetMapping(value = "invoices")
	public ResponseEntity<?> getAllInvoices() {
		try {
			return ResponseEntity.ok(invoiceService.getAllInvoices());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "invoice/{id}")
	public ResponseEntity<?> getInvoiceById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(invoiceService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
