package com.springboot.assetmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.model.AssetCondition;

@Repository
public class AssetConditionDaoImpl extends BaseDaoImpl implements AssetConditionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<AssetCondition> getAllAssetCondition() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ac.* ")
		.append("FROM tbl_asset_condition ac ") 
		.append("WHERE ac.is_active = true ");
		
		List<AssetCondition> list = em.createNativeQuery(sb.toString(), AssetCondition.class)
				.getResultList();
		
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AssetCondition getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ac.* ")
		.append("FROM tbl_asset_condition ac ") 
		.append("WHERE ac.id = (:id)\\:\\:text ") 
		.append("AND ac.is_active = true ");
		
		List<AssetCondition> list = em.createNativeQuery(sb.toString(), AssetCondition.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	@Override
	public void add(AssetCondition asetCondition) throws Exception {
		em.persist(asetCondition);
	}

	@Override
	public void update(AssetCondition assetCondition) throws Exception {
		em.merge(assetCondition);
	}

	@Override
	public void delete(String id) throws Exception {
		String sql = "DELETE FROM tbl_asset_condition assetcondition where assetcondition.id = :id";
		em.createNativeQuery(sql).setParameter("id", id).executeUpdate();		
	}

	
}
