package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.Item;

public interface ItemDao {

	List<Item> getAllItems() throws Exception;
	
	Item getById(String id) throws Exception;
	
}
