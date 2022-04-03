package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.DetailTransactionInDao;
import com.springboot.assetmanagement.dao.TransactionInDao;
import com.springboot.assetmanagement.dto.DetailTransactionInDto;
import com.springboot.assetmanagement.dto.PostDetailTransactionInDto;
import com.springboot.assetmanagement.model.Asset;
import com.springboot.assetmanagement.model.AssetCondition;
import com.springboot.assetmanagement.model.DetailTransactionIn;
import com.springboot.assetmanagement.model.TransactionIn;
import com.springboot.login.service.BaseServiceImpl;

@Service
public class DetailTransactionInServiceImpl extends BaseServiceImpl implements DetailTransactionInService {

	@Autowired
	private DetailTransactionInDao detailTrxInDao;

	@Autowired
	private TransactionInDao trxInDao;

	@Override
	public List<DetailTransactionInDto> getByTrxInId(String trxInId) throws Exception {
		return detailTrxInDao.getByTrxInId(trxInId);
	}

	@Override
	@Transactional
	public void addTransactionInDetail(PostDetailTransactionInDto detailTransactionInDto) throws Exception {
		DetailTransactionIn detailTrxIn = new DetailTransactionIn();

		TransactionIn trxIn = trxInDao.getIdByEntity(detailTransactionInDto.getParentTrxId());
		trxIn.setId(detailTransactionInDto.getParentTrxId());
		detailTrxIn.setTransactionIn(trxIn);

		Asset asset = new Asset();
		asset.setId(detailTransactionInDto.getAssetId());
		detailTrxIn.setAsset(asset);
		
		AssetCondition assetCondition = new AssetCondition();
		assetCondition.setId(detailTransactionInDto.getAssetConditionId());
		detailTrxIn.setAssetCondition(assetCondition);

		detailTrxIn.setCreatedBy("admin");
		detailTrxIn.setCreatedDate(LocalDateTime.now());
		detailTrxIn.setVersion(0L);
		detailTrxIn.setIsActive(true);

		detailTrxInDao.addTransactionInDetail(detailTrxIn);
	}

}
