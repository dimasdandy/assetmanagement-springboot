package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.AssetCondition;

public interface AssetConditionDao {

	List<AssetCondition> getAllAssetCondition() throws Exception;
	
	AssetCondition getById(String id) throws Exception;
	
}
