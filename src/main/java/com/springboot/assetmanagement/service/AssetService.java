package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.Asset;

public interface AssetService {

	Asset getById(String id) throws Exception;

	//	Long insert(InsertUserReqDto users) throws Exception;

//	void update(UpdateUserReqDto data) throws Exception;

//	void delete(Long id) throws Exception;

//	List<FindAllPathUsersResData> getAll() throws Exception;

}
