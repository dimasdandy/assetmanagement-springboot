package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.ItemDao;
import com.springboot.assetmanagement.model.Item;
import com.springboot.assetmanagement.model.ItemType;

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

	@Override
	@Transactional
	public void add(Item item) throws Exception {
		ItemType itemType = new ItemType();
		itemType.setId(item.getItemType().getId());
		item.setItemType(itemType);
		
		item.setDescription(item.getDescription());
		item.setBrand(item.getBrand());
		item.setSerial(item.getSerial());
		item.setPrice(item.getPrice());
		item.setCreatedBy("admin");
		item.setCreatedDate(LocalDateTime.now());
		item.setVersion(0L);
		item.setIsActive(true);
		itemDao.add(item);
	}

	@Override
	@Transactional
	public void update(Item item) throws Exception {
		Item items = getById(item.getId());
		if (items.getId() == null || items.getId().isEmpty()) {
			throw new ValidationException("id cannot be null.");
		}
		
		ItemType itemType = new ItemType();
		itemType.setId(item.getItemType().getId());
		item.setItemType(itemType);
		
		item.setDescription(item.getDescription());
		item.setBrand(item.getBrand());
		item.setSerial(item.getSerial());
		item.setPrice(item.getPrice());
		item.setCreatedBy(items.getCreatedBy());
		item.setCreatedDate(items.getCreatedDate());
		item.setUpdatedBy("admin");
		item.setUpdatedDate(LocalDateTime.now());
		item.setVersion(item.getVersion()+1L);
		itemDao.update(item);
	}

	@Override
	@Transactional
	public void delete(String id) throws Exception {
		Item item = new Item();
		item.setId(id);
		itemDao.delete(id);
	}

}
