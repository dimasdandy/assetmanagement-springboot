package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.Asset;

public interface AssetService {

	List<Asset> getAllAsset() throws Exception;
	
	Asset getById(String id) throws Exception;

}
