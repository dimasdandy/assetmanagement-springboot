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

import com.springboot.assetmanagement.model.StatusAsset;
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
	
	@PostMapping(value = "status-asset")
	public ResponseEntity<?> add(@RequestBody StatusAsset statusAsset) throws Exception {
		try {
			statusAssetService.add(statusAsset);
			return ResponseEntity.ok("status-asset has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "status-asset")
	public ResponseEntity<?> update(@RequestBody StatusAsset statusAsset) throws Exception {
		try {
			statusAssetService.update(statusAsset);
			return ResponseEntity.ok("status-asset has been updated.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "status-asset/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			statusAssetService.delete(id);
			return ResponseEntity.ok("status-asset has been deleted.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
