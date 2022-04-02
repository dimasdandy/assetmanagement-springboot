package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.dto.PostTransactionOutDto;
import com.springboot.assetmanagement.dto.TransactionOutDto;
import com.springboot.assetmanagement.model.TransactionOut;

public interface TransactionOutService {

	List<TransactionOutDto> getAllTrxOut() throws Exception;
	
	TransactionOutDto getByIdWithDetails(String id) throws Exception;
	
	TransactionOut getIdByEntity(String id) throws Exception;
	
	void addTransactionOut(PostTransactionOutDto transactionOutDto) throws Exception;

}
