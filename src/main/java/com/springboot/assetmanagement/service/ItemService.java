package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.Item;

public interface ItemService {

	List<Item> getAllItems() throws Exception;

	Item getById(String id) throws Exception;
	
	void add(Item item) throws Exception;

	void update(Item item) throws Exception;
	
	void delete(String id) throws Exception;

}
