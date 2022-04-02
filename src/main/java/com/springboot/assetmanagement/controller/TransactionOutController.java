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

import com.springboot.assetmanagement.dto.PostTransactionOutDto;
import com.springboot.assetmanagement.service.TransactionOutService;

@RestController
@RequestMapping(value = "api/")
public class TransactionOutController {

	@Autowired
	private TransactionOutService trxOutService;
	
	@GetMapping(value = "transactions-out")
	public ResponseEntity<?> getAllTransactionOut() {
		try {
			return ResponseEntity.ok(trxOutService.getAllTrxOut());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "transaction-out/{id}")
	public ResponseEntity<?> getTransactionOutById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(trxOutService.getByIdWithDetails(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping(value = "transaction-out")
	public ResponseEntity<?> addTrxOut(@RequestBody PostTransactionOutDto transactionOutDto) throws Exception {
		try {
			trxOutService.addTransactionOut(transactionOutDto);
			return ResponseEntity.ok("transaction has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
