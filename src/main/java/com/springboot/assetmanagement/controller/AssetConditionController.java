package com.springboot.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assetmanagement.service.AssetConditionService;

@RestController
@RequestMapping(value = "api/")
public class AssetConditionController {

	@Autowired
	private AssetConditionService assetConditionService;
	
	@GetMapping(value = "assets-condition")
	public ResponseEntity<?> getAllAssetCondition() {
		try {
			return ResponseEntity.ok(assetConditionService.getAllAssetCondition());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "asset-condition/{id}")
	public ResponseEntity<?> getAssetConditionById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(assetConditionService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
