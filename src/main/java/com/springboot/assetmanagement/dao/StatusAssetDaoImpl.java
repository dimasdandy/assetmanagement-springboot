package com.springboot.assetmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.model.StatusAsset;

@Repository
public class StatusAssetDaoImpl extends BaseDaoImpl implements StatusAssetDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<StatusAsset> getAllStatusAsset() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT statusasset.* ")
		.append("FROM tbl_status_assets statusasset ") 
		.append("WHERE statusasset.is_active = true ");
		
		List<StatusAsset> list = em.createNativeQuery(sb.toString(), StatusAsset.class)
				.getResultList();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public StatusAsset getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT statusasset.* ")
		.append("FROM tbl_status_assets statusasset ") 
		.append("WHERE statusasset.id = (:id)\\:\\:text ") 
		.append("AND statusasset.is_active = true ");
		
		List<StatusAsset> list = em.createNativeQuery(sb.toString(), StatusAsset.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	
}
