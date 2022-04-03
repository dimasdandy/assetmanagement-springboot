package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.AssetDao;
import com.springboot.assetmanagement.model.Asset;
import com.springboot.assetmanagement.model.Company;
import com.springboot.assetmanagement.model.Invoice;
import com.springboot.assetmanagement.model.Item;
import com.springboot.assetmanagement.model.StatusAsset;

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

	@Override
	@Transactional
	public void add(Asset asset) throws Exception {
		asset.setCode(asset.getCode());
		asset.setExpiredDate(asset.getExpiredDate());
		
		Item item = new Item();
		item.setId(asset.getItem().getId());
		asset.setItem(item);
		
		StatusAsset statusAsset = new StatusAsset();
		statusAsset.setId(asset.getStatusAsset().getId());
		asset.setStatusAsset(statusAsset);
		
		Company company = new Company();
		company.setId(asset.getCompany().getId());
		asset.setCompany(company);
		
		Invoice invoice = new Invoice();
		invoice.setId(asset.getInvoice().getId());
		asset.setInvoice(invoice);
		
		asset.setCreatedBy("admin");
		asset.setCreatedDate(LocalDateTime.now());
		asset.setVersion(0L);
		asset.setIsActive(true);
		assetDao.add(asset);
	}

	@Override
	@Transactional
	public void update(Asset asset) throws Exception {
		Asset assets = getById(asset.getId());
		if (assets.getId() == null || assets.getId().isEmpty()) {
			throw new ValidationException("id cannot be null.");
		}
		
		asset.setCode(asset.getCode());
		asset.setExpiredDate(asset.getExpiredDate());
		
		Item item = new Item();
		item.setId(asset.getItem().getId());
		asset.setItem(item);
		
		StatusAsset statusAsset = new StatusAsset();
		statusAsset.setId(asset.getStatusAsset().getId());
		asset.setStatusAsset(statusAsset);
		
		Company company = new Company();
		company.setId(asset.getCompany().getId());
		asset.setCompany(company);
		
		Invoice invoice = new Invoice();
		invoice.setId(asset.getInvoice().getId());
		asset.setInvoice(invoice);
		
		asset.setCreatedBy(assets.getCreatedBy());
		asset.setCreatedDate(assets.getCreatedDate());
		asset.setUpdatedBy("admin");
		asset.setUpdatedDate(LocalDateTime.now());
		asset.setVersion(assets.getVersion()+1L);
		assetDao.update(asset);
	}

	@Override
	@Transactional
	public void delete(String id) throws Exception {
		Asset asset = new Asset();
		asset.setId(id);
		assetDao.delete(id);
	}

}
