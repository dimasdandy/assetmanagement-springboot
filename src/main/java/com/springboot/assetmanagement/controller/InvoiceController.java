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

import com.springboot.assetmanagement.model.Invoice;
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
	
	@PostMapping(value = "invoice")
	public ResponseEntity<?> add(@RequestBody Invoice invoice) throws Exception {
		try {
			invoiceService.add(invoice);
			return ResponseEntity.ok("invoice has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "invoice")
	public ResponseEntity<?> update(@RequestBody Invoice invoice) throws Exception {
		try {
			invoiceService.update(invoice);
			return ResponseEntity.ok("invoice has been updated.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "invoice/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			invoiceService.delete(id);
			return ResponseEntity.ok("invoice has been deleted.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
