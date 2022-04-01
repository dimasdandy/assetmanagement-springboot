package com.springboot.assetmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/")
public class DetailTransactionOutController {

	@GetMapping(value = "detail-transactions-out")
	public ResponseEntity<?> getAllDetailTransactionOut() {
		try {
//			return ResponseEntity.ok();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "detail-transaction-out/{id}")
	public ResponseEntity<?> getDetailTransactionInById(String id) {
		try {
//			return ResponseEntity.ok();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
