package com.springboot.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assetmanagement.service.AssetService;

@RestController
@RequestMapping(value = "api/")
public class AssetController {

	@Autowired
	private AssetService assetService;

	@GetMapping(value = "assets")
	public ResponseEntity<?> getAllAsset() {
		try {
			return ResponseEntity.ok(assetService.getAllAsset());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping(value = "asset/{id}")
	public ResponseEntity<?> getAssetById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(assetService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
