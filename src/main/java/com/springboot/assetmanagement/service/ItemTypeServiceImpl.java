package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

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

	@Override
	@Transactional
	public void add(ItemType itemType) throws Exception {
		itemType.setCode(itemType.getCode());
		itemType.setName(itemType.getName());
		itemType.setCreatedBy("admin");
		itemType.setCreatedDate(LocalDateTime.now());
		itemType.setVersion(0L);
		itemType.setIsActive(true);
		itemTypeDao.add(itemType);		
	}

	@Override
	@Transactional
	public void update(ItemType itemType) throws Exception {
		ItemType it = getById(itemType.getId());
		if (it.getId() == null || it.getId().isEmpty()) {
			throw new ValidationException("id cannot be null.");
		}
		itemType.setCode(itemType.getCode());
		itemType.setName(itemType.getName());
		itemType.setCreatedBy(it.getCreatedBy());
		itemType.setCreatedDate(it.getCreatedDate());
		itemType.setUpdatedBy("admin");
		itemType.setUpdatedDate(LocalDateTime.now());
		itemType.setVersion(itemType.getVersion()+1L);
		itemTypeDao.update(itemType);		
	}

	@Override
	@Transactional
	public void delete(String id) throws Exception {
		ItemType itemType = new ItemType();
		itemType.setId(id);
		itemTypeDao.delete(id);
	}

}
