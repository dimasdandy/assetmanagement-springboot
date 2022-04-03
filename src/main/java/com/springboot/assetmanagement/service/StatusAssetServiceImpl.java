package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

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

	@Override
	@Transactional
	public void add(StatusAsset statusAsset) throws Exception {
		statusAsset.setCode(statusAsset.getCode());
		statusAsset.setName(statusAsset.getName());
		statusAsset.setCreatedBy("admin");
		statusAsset.setCreatedDate(LocalDateTime.now());
		statusAsset.setVersion(0L);
		statusAsset.setIsActive(true);
		statusAssetDao.add(statusAsset);		
	}

	@Override
	@Transactional
	public void update(StatusAsset statusAsset) throws Exception {
		StatusAsset sa = getById(statusAsset.getId());
		if (sa.getId() == null || sa.getId().isEmpty()) {
			throw new ValidationException("id cannot be null.");
		}
		statusAsset.setCode(statusAsset.getCode());
		statusAsset.setName(statusAsset.getName());
		statusAsset.setCreatedBy(sa.getCreatedBy());
		statusAsset.setCreatedDate(sa.getCreatedDate());
		statusAsset.setUpdatedBy("admin");
		statusAsset.setUpdatedDate(LocalDateTime.now());
		statusAsset.setVersion(statusAsset.getVersion()+1L);
		statusAssetDao.update(statusAsset);		
	}

	@Override
	@Transactional
	public void delete(String id) throws Exception {
		StatusAsset statusAsset = new StatusAsset();
		statusAsset.setId(id);
		statusAssetDao.delete(id);
	}

}
