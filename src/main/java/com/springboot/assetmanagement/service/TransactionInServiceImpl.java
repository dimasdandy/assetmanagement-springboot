package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.TransactionInDao;
import com.springboot.assetmanagement.dto.PostDetailTransactionInDto;
import com.springboot.assetmanagement.dto.PostTransactionInDto;
import com.springboot.assetmanagement.dto.TransactionInDto;
import com.springboot.assetmanagement.model.TransactionIn;
import com.springboot.assetmanagement.model.TransactionOut;
import com.springboot.login.service.BaseServiceImpl;

@Service
public class TransactionInServiceImpl extends BaseServiceImpl implements TransactionInService {

	@Autowired
	private TransactionInDao trxInDao;
	
	@Autowired
	private DetailTransactionInService detailTrxInService;

	@Override
	public List<TransactionInDto> getAllTrxIn() throws Exception {
		return trxInDao.getAllTrxIn();
	}

	@Override
	public TransactionInDto getByIdWithDetails(String id) throws Exception {
		TransactionInDto trxIn = trxInDao.getById(id);
		if (trxIn.getId() != null) {
			trxIn.setDetailTransactionIn(detailTrxInService.getByTrxInId(trxIn.getId()));
		} else {
			throw new ValidationException("transaction in id cannot be null.");
		}
		return null;
	}

	@Override
	public TransactionIn getIdByEntity(String id) throws Exception {
		return trxInDao.getIdByEntity(id);
	}

	@Override
	@Transactional
	public void addTransactionIn(PostTransactionInDto transactionInDto) throws Exception {
		TransactionIn trxIn = new TransactionIn();
		trxIn.setCode(transactionInDto.getCode());
		
		TransactionOut trxOut = new TransactionOut();
		trxOut.setId(transactionInDto.getTransactionOutId());
		trxIn.setTransactionOut(trxOut);
		
		trxIn.setCheckInDate(transactionInDto.getCheckInDate());
		trxIn.setCreatedBy("admin");
		trxIn.setCreatedDate(LocalDateTime.now());
		trxIn.setVersion(0L);
		trxIn.setIsActive(true);
		trxInDao.addTransactionIn(trxIn);
		
		for (PostDetailTransactionInDto detailTrxInDto : transactionInDto.getDetailTransactionIn()) {
			detailTrxInDto.setParentTrxId(trxIn.getId());
			detailTrxInService.addTransactionInDetail(detailTrxInDto);
		}
	}
	
	
	
}
