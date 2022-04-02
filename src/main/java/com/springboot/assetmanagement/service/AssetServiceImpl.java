package com.springboot.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.AssetDao;
import com.springboot.assetmanagement.model.Asset;

@Service
public class AssetServiceImpl implements AssetService {

	@Autowired
	private AssetDao assetDao;

	@Override
	public Asset getById(String id) throws Exception {
		return assetDao.getById(id);
	}

	@Override
	public List<Asset> getAllAsset() throws Exception {
		return assetDao.getAllAsset();
	}

}
