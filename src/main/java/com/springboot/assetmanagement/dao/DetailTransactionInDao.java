package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.dto.DetailTransactionInDto;
import com.springboot.assetmanagement.model.DetailTransactionIn;

public interface DetailTransactionInDao {

	List<DetailTransactionInDto> getByTrxInId(String trxInId) throws Exception;
	
	void addTransactionInDetail(DetailTransactionIn detailTransactionIn) throws Exception;

}
