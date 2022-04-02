package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.dto.DetailTransactionInDto;
import com.springboot.assetmanagement.dto.PostDetailTransactionInDto;
import com.springboot.assetmanagement.dto.PostDetailTransactionOutDto;

public interface DetailTransactionInService {

	List<DetailTransactionInDto> getByTrxInId(String trxInId) throws Exception;
	
	void addTransactionInDetail(PostDetailTransactionInDto detailTransactionInDto) throws Exception;

}
