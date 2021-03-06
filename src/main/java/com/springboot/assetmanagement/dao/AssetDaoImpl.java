package com.springboot.assetmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.model.Asset;

@Repository
public class AssetDaoImpl extends BaseDaoImpl implements AssetDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAsset() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT asset.* ")
		.append("FROM tbl_assets asset ") 
		.append("WHERE asset.is_active = true ");
		
		List<Asset> list = em.createNativeQuery(sb.toString(), Asset.class)
				.getResultList();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Asset getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT asset.* ")
		.append("FROM tbl_assets asset ") 
		.append("WHERE asset.id = (:id)\\:\\:text ") 
		.append("AND asset.is_active = true ");
		
		List<Asset> list = em.createNativeQuery(sb.toString(), Asset.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	@Override
	public void add(Asset asset) throws Exception {
		em.persist(asset);
	}

	@Override
	public void update(Asset asset) throws Exception {
		em.merge(asset);
	}

	@Override
	public void delete(String id) throws Exception {
		String sql = "DELETE FROM tbl_assets asset where asset.id = :id";
		em.createNativeQuery(sql).setParameter("id", id).executeUpdate();
	}

	
}
