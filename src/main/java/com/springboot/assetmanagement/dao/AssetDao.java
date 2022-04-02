package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.Asset;

public interface AssetDao {

	List<Asset> getAllAsset() throws Exception;
	
	Asset getById(String id) throws Exception;
	
}
