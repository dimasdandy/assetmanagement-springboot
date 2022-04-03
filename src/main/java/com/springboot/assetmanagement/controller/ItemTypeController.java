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

import com.springboot.assetmanagement.model.ItemType;
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
	
	@PostMapping(value = "item-type")
	public ResponseEntity<?> add(@RequestBody ItemType itemType) throws Exception {
		try {
			itemTypeService.add(itemType);
			return ResponseEntity.ok("itemType has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "item-type")
	public ResponseEntity<?> update(@RequestBody ItemType itemType) throws Exception {
		try {
			itemTypeService.update(itemType);
			return ResponseEntity.ok("itemType has been updated.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "item-type/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			itemTypeService.delete(id);
			return ResponseEntity.ok("itemType has been deleted.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
