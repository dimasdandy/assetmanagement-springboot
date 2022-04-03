package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.TransactionOutDao;
import com.springboot.assetmanagement.dto.PostTransactionOutDto;
import com.springboot.assetmanagement.dto.TransactionOutDto;
import com.springboot.assetmanagement.model.Employee;
import com.springboot.assetmanagement.model.TransactionOut;

@Service
public class TransactionOutServiceImpl implements TransactionOutService {

	@Autowired
	private TransactionOutDao trxOutDao;
	
	@Autowired
	private DetailTransactionOutService detailTrxOutService;
	
	@Override
	public TransactionOutDto getByIdWithDetails(String id) throws Exception {
		TransactionOutDto trxOut = trxOutDao.getById(id);
		if (trxOut.getId() != null) {
			trxOut.setDetailTransactionOut(detailTrxOutService.getByTrxOutId(trxOut.getId()));
		} else {
			throw new ValidationException("transaction out id cannot be null.");
		}
		return trxOut;
	}
	

	@Override
	public TransactionOut getIdByEntity(String id) throws Exception {
		return trxOutDao.getIdByEntity(id);
	}

	@Override
	public List<TransactionOutDto> getAllTrxOut() throws Exception {
		return trxOutDao.getAllTrxOut();
	}

	@Override
	@Transactional (rollbackOn = RuntimeException.class)
	public void addTransactionOut(PostTransactionOutDto transactionOutDto) throws Exception {
		TransactionOut trxOut = new TransactionOut();
		trxOut.setCode(transactionOutDto.getCode());
		
		Employee employee = new Employee();
		employee.setId(transactionOutDto.getEmployeeId());
		trxOut.setEmployee(employee);
		
		trxOut.setCheckOutDate(transactionOutDto.getCheckOutDate());
		trxOut.setCreatedBy("admin");
		trxOut.setCreatedDate(LocalDateTime.now());
		trxOut.setVersion(0L);
		trxOut.setIsActive(true);
		trxOutDao.addTransactionOut(trxOut);
		
		transactionOutDto.getDetailTransactionOut().stream()
		.filter(data -> {
			try {
				if (data.getAssetId() == null) {
					throw new RuntimeException("asset id cannot be null.");
				} else {
					return true;
				}
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
		})
		.forEach(data -> {
			data.setParentTrxId(trxOut.getId());
			try {
				detailTrxOutService.addTransactionOutDetail(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
}
