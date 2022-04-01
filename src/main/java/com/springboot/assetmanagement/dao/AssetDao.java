package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.Asset;

public interface AssetDao {

	Asset getById(String id) throws Exception;

	//	void insert(Users data) throws Exception;

//	void update(Users data) throws Exception;

//	void delete(Long id) throws Exception;
	
//	List<Users> getAll() throws Exception;

	
}
