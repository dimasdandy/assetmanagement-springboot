package com.springboot.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assetmanagement.service.StatusAssetService;

@RestController
@RequestMapping(value = "api/")
public class StatusAssetController {

	@Autowired
	private StatusAssetService statusAssetService;
	
	@GetMapping(value = "status-assets")
	public ResponseEntity<?> getAllStatusAsset() {
		try {
			return ResponseEntity.ok(statusAssetService.getAllStatusAsset());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "status-asset/{id}")
	public ResponseEntity<?> getStatusAssetById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(statusAssetService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
