package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.AssetCondition;

public interface AssetConditionService {

	List<AssetCondition> getAllAssetCondition() throws Exception;
	
	AssetCondition getById(String id) throws Exception;

}
