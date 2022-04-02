package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.dto.DetailTransactionOutDto;
import com.springboot.assetmanagement.dto.PostDetailTransactionOutDto;

public interface DetailTransactionOutService {

	List<DetailTransactionOutDto> getByTrxOutId(String trxOutId) throws Exception;
	
	void addTransactionOutDetail(PostDetailTransactionOutDto detailTransactionOutDto) throws Exception;

}
