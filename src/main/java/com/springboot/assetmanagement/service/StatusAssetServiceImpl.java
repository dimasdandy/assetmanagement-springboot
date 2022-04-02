package com.springboot.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.StatusAssetDao;
import com.springboot.assetmanagement.model.StatusAsset;

@Service
public class StatusAssetServiceImpl implements StatusAssetService {

	@Autowired
	private StatusAssetDao statusAssetDao;

	@Override
	public StatusAsset getById(String id) throws Exception {
		return statusAssetDao.getById(id);
	}

	@Override
	public List<StatusAsset> getAllStatusAsset() throws Exception {
		return statusAssetDao.getAllStatusAsset();
	}

}
