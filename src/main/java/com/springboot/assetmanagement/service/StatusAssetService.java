package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.StatusAsset;

public interface StatusAssetService {

	List<StatusAsset> getAllStatusAsset() throws Exception;
	
	StatusAsset getById(String id) throws Exception;
	
	void add(StatusAsset statusAsset) throws Exception;

	void update(StatusAsset statusAsset) throws Exception;
	
	void delete(String id) throws Exception;

}
