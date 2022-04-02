package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.dto.DetailTransactionOutDto;
import com.springboot.assetmanagement.model.DetailTransactionOut;

public interface DetailTransactionOutDao {

	List<DetailTransactionOutDto> getByTrxOutId(String trxOutId) throws Exception;
	
	void addTransactionOutDetail(DetailTransactionOut detailTransactionOut) throws Exception;

}
