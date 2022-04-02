package com.springboot.assetmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.assetmanagement.service.ItemTypeService;

@RestController
@RequestMapping(value = "api/")
public class ItemTypeController {

	@Autowired
	private ItemTypeService itemTypeService;
	
	@GetMapping(value = "item-types")
	public ResponseEntity<?> getAllItemType() {
		try {
			return ResponseEntity.ok(itemTypeService.getAllItemTypes());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "item-type/{id}")
	public ResponseEntity<?> getItemTypeById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(itemTypeService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
