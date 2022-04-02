package com.springboot.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.ItemTypeDao;
import com.springboot.assetmanagement.model.ItemType;

@Service
public class ItemTypeServiceImpl implements ItemTypeService {

	@Autowired
	private ItemTypeDao itemTypeDao;

	@Override
	public ItemType getById(String id) throws Exception {
		return itemTypeDao.getById(id);
	}

	@Override
	public List<ItemType> getAllItemTypes() throws Exception {
		return itemTypeDao.getAllItemTypes();
	}

}
