package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.AssetConditionDao;
import com.springboot.assetmanagement.model.AssetCondition;
import com.springboot.assetmanagement.model.StatusAsset;
import com.springboot.login.service.BaseServiceImpl;

@Service
public class AssetConditionServiceImpl extends BaseServiceImpl implements AssetConditionService {

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

	@Override
	@Transactional
	public void add(AssetCondition assetCondition) throws Exception {
		assetCondition.setCode(assetCondition.getCode());
		assetCondition.setName(assetCondition.getName());

		StatusAsset statusAsset = new StatusAsset();
		statusAsset.setId(assetCondition.getStatusAsset().getId());
		assetCondition.setStatusAsset(statusAsset);

		assetCondition.setCreatedBy("admin");
		assetCondition.setCreatedDate(LocalDateTime.now());
		assetCondition.setVersion(0L);
		assetCondition.setIsActive(true);
		assetConditionDao.add(assetCondition);
	}

	@Override
	@Transactional
	public void update(AssetCondition assetCondition) throws Exception {
		AssetCondition assetConditions = getById(assetCondition.getId());
		if (assetConditions.getId() == null || assetConditions.getId().isEmpty()) {
			throw new ValidationException("id cannot be null.");
		}
		
		assetCondition.setCode(assetCondition.getCode());
		assetCondition.setName(assetCondition.getName());

		StatusAsset statusAsset = new StatusAsset();
		statusAsset.setId(assetCondition.getStatusAsset().getId());
		assetCondition.setStatusAsset(statusAsset);

		assetCondition.setCreatedBy(assetConditions.getCreatedBy());
		assetCondition.setCreatedDate(assetConditions.getCreatedDate());
		assetCondition.setUpdatedBy("admin");
		assetCondition.setUpdatedDate(LocalDateTime.now());
		assetCondition.setVersion(assetCondition.getVersion()+1L);
		assetConditionDao.update(assetCondition);
	}

	@Override
	@Transactional
	public void delete(String id) throws Exception {
		AssetCondition assetCondition = new AssetCondition();
		assetCondition.setId(id);
		assetConditionDao.delete(id);
	}

}
