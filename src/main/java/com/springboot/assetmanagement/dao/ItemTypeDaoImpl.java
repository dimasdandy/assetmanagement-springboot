package com.springboot.assetmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.model.ItemType;

@Repository
public class ItemTypeDaoImpl extends BaseDaoImpl implements ItemTypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemType> getAllItemTypes() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT itemtype.* ")
		.append("FROM tbl_item_types itemtype ") 
		.append("WHERE itemtype.is_active = true ");
		
		List<ItemType> list = em.createNativeQuery(sb.toString(), ItemType.class)
				.getResultList();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ItemType getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT itemtype.* ")
		.append("FROM tbl_item_types itemtype ") 
		.append("WHERE itemtype.id = (:id)\\:\\:text ") 
		.append("AND itemtype.is_active = true ");
		
		List<ItemType> list = em.createNativeQuery(sb.toString(), ItemType.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	@Override
	public void add(ItemType itemType) throws Exception {
		// TODO Auto-generated method stub
		em.persist(itemType);
	}

	@Override
	public void update(ItemType itemType) throws Exception {
		// TODO Auto-generated method stub
		em.merge(itemType);
	}

	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM tbl_item_types itemtype where itemtype.id = :id";
		em.createNativeQuery(sql).setParameter("id", id).executeUpdate();
	}

	
}
