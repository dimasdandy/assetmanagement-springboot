package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.ItemType;

public interface ItemTypeService {

	List<ItemType> getAllItemTypes() throws Exception;
	
	ItemType getById(String id) throws Exception;
	
	void add(ItemType itemType) throws Exception;

	void update(ItemType itemType) throws Exception;
	
	void delete(String id) throws Exception;

}
