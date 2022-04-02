package com.springboot.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.AssetConditionDao;
import com.springboot.assetmanagement.model.AssetCondition;

@Service
public class AssetConditionServiceImpl implements AssetConditionService {

	@Autowired
	private AssetConditionDao assetConditionDao;

	@Override
	public AssetCondition getById(String id) throws Exception {
		return assetConditionDao.getById(id);
	}

	@Override
	public List<AssetCondition> getAllAssetCondition() throws Exception {
		return assetConditionDao.getAllAssetCondition();
	}

}
