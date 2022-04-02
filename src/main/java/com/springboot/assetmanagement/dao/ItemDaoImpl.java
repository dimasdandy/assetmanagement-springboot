package com.springboot.assetmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.model.Item;

@Repository
public class ItemDaoImpl extends BaseDaoImpl implements ItemDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItems() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT item.* ")
		.append("FROM tbl_items item ") 
		.append("WHERE item.is_active = true ");
		
		List<Item> list = em.createNativeQuery(sb.toString(), Item.class)
				.getResultList();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Item getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT item.* ")
		.append("FROM tbl_items item ") 
		.append("WHERE item.id = (:id)\\:\\:text ") 
		.append("AND item.is_active = true ");
		
		List<Item> list = em.createNativeQuery(sb.toString(), Item.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	
}
