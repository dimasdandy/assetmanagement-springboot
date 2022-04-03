package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.StatusAsset;

public interface StatusAssetDao {

	List<StatusAsset> getAllStatusAsset() throws Exception;
	
	StatusAsset getById(String id) throws Exception;

	void add(StatusAsset statusAsset) throws Exception;

	void update(StatusAsset statusAsset) throws Exception;
	
	void delete(String id) throws Exception;
}
