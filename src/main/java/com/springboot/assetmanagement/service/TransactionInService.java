package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.dto.PostTransactionInDto;
import com.springboot.assetmanagement.dto.TransactionInDto;
import com.springboot.assetmanagement.model.TransactionIn;

public interface TransactionInService {

	List<TransactionInDto> getAllTrxIn() throws Exception;

	TransactionInDto getByIdWithDetails(String id) throws Exception;

	TransactionIn getIdByEntity(String id) throws Exception;

	void addTransactionIn(PostTransactionInDto transactionInDto) throws Exception;

}
