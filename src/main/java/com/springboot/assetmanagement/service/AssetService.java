package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.Asset;

public interface AssetService {

	List<Asset> getAllAsset() throws Exception;
	
	Asset getById(String id) throws Exception;

	void add(Asset asset) throws Exception;

	void update(Asset asset) throws Exception;
	
	void delete(String id) throws Exception;
}
