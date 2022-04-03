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

import com.springboot.assetmanagement.model.AssetCondition;
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
	
	@PostMapping(value = "asset-condition")
	public ResponseEntity<?> add(@RequestBody AssetCondition assetCondition) throws Exception {
		try {
			assetConditionService.add(assetCondition);
			return ResponseEntity.ok("assetCondition has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "asset-condition")
	public ResponseEntity<?> update(@RequestBody AssetCondition assetCondition) throws Exception {
		try {
			assetConditionService.update(assetCondition);
			return ResponseEntity.ok("assetCondition has been updated.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "asset-condition/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			assetConditionService.delete(id);
			return ResponseEntity.ok("assetCondition has been deleted.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
