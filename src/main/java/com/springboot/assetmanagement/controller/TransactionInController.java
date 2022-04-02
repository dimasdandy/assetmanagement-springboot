package com.springboot.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assetmanagement.dto.PostTransactionInDto;
import com.springboot.assetmanagement.service.TransactionInService;

@RestController
@RequestMapping(value = "api/")
public class TransactionInController {

	@Autowired
	TransactionInService trxInService;
	
	@GetMapping(value = "transactions-in")
	public ResponseEntity<?> getAllTransactionIn() {
		try {
			return ResponseEntity.ok(trxInService.getAllTrxIn());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "transaction-in/{id}")
	public ResponseEntity<?> getTransactionInById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(trxInService.getByIdWithDetails(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping(value = "transaction-in")
	public ResponseEntity<?> addTrxIn(@RequestBody PostTransactionInDto transactionInDto) throws Exception {
		try {
			trxInService.addTransactionIn(transactionInDto);
			return ResponseEntity.ok("transaction has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
}
