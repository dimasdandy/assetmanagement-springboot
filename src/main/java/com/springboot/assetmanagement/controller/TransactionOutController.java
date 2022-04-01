package com.springboot.assetmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/")
public class TransactionOutController {

	@GetMapping(value = "transactions-out")
	public ResponseEntity<?> getAllTransactionOut() {
		try {
//			return ResponseEntity.ok();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "transaction-out/{id}")
	public ResponseEntity<?> getTransactionOutById(String id) {
		try {
//			return ResponseEntity.ok();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
