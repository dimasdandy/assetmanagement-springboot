package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.dto.TransactionInDto;
import com.springboot.assetmanagement.model.TransactionIn;

public interface TransactionInDao {

	List<TransactionInDto> getAllTrxIn() throws Exception;
	
	TransactionInDto getById(String id) throws Exception;
	
	TransactionIn getIdByEntity(String id) throws Exception;

	void addTransactionIn(TransactionIn transactionIn) throws Exception;
	
}
