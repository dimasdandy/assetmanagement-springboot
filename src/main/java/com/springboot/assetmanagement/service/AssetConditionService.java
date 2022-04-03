package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.AssetCondition;

public interface AssetConditionService {

	List<AssetCondition> getAllAssetCondition() throws Exception;
	
	AssetCondition getById(String id) throws Exception;
	
	void add(AssetCondition assetCondition) throws Exception;

	void update(AssetCondition assetCondition) throws Exception;
	
	void delete(String id) throws Exception;

}
