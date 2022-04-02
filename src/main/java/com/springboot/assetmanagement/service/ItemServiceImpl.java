package com.springboot.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.ItemDao;
import com.springboot.assetmanagement.model.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	@Override
	public Item getById(String id) throws Exception {
		return itemDao.getById(id);
	}

	@Override
	public List<Item> getAllItems() throws Exception {
		return itemDao.getAllItems();
	}

}
