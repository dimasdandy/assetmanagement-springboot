package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.ItemType;

public interface ItemTypeDao {

	List<ItemType> getAllItemTypes() throws Exception;
	
	ItemType getById(String id) throws Exception;
	
}
