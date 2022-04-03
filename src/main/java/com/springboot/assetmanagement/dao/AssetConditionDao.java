package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.AssetCondition;

public interface AssetConditionDao {

	List<AssetCondition> getAllAssetCondition() throws Exception;
	
	AssetCondition getById(String id) throws Exception;
	
	void add(AssetCondition asetCondition) throws Exception;

	void update(AssetCondition assetCondition) throws Exception;
	
	void delete(String id) throws Exception;
	
}
