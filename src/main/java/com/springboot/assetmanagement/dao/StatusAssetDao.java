package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.StatusAsset;

public interface StatusAssetDao {

	List<StatusAsset> getAllStatusAsset() throws Exception;
	
	StatusAsset getById(String id) throws Exception;
	
}
