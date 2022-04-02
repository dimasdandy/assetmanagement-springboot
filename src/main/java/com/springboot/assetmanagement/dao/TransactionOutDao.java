package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.dto.TransactionOutDto;
import com.springboot.assetmanagement.model.TransactionOut;

public interface TransactionOutDao {

	List<TransactionOutDto> getAllTrxOut() throws Exception;
	
	TransactionOutDto getById(String id) throws Exception;
	
	TransactionOut getIdByEntity(String id) throws Exception;

	void addTransactionOut(TransactionOut transactionOut) throws Exception;
	
}
