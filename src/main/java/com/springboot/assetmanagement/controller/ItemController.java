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

import com.springboot.assetmanagement.model.Item;
import com.springboot.assetmanagement.service.ItemService;

@RestController
@RequestMapping(value = "api/")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@GetMapping(value = "items")
	public ResponseEntity<?> getAllItems() {
		try {
			return ResponseEntity.ok(itemService.getAllItems());
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping(value = "item/{id}")
	public ResponseEntity<?> getItemById(@PathVariable String id) {
		try {
			return ResponseEntity.ok(itemService.getById(id));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PostMapping(value = "item")
	public ResponseEntity<?> add(@RequestBody Item item) throws Exception {
		try {
			itemService.add(item);
			return ResponseEntity.ok("item has been added.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@PutMapping(value = "item")
	public ResponseEntity<?> update(@RequestBody Item item) throws Exception {
		try {
			itemService.update(item);
			return ResponseEntity.ok("item has been updated.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "item/{id}")
	public ResponseEntity<?> delete(@PathVariable String id) {
		try {
			itemService.delete(id);
			return ResponseEntity.ok("item has been deleted.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
