package com.springboot.assetmanagement.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.dto.TransactionInDto;
import com.springboot.assetmanagement.model.TransactionIn;

@Repository
public class TransactionInDaoImpl extends BaseDaoImpl implements TransactionInDao {

	@Override
	public List<TransactionInDto> getAllTrxIn() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT tin.id, tin.code, tin.check_in_date, ") 
		.append("tin.created_date, tin.updated_by, tin.updated_date, ") 
		.append("tin.VERSION, tin.is_active ") 
		.append("FROM tbl_transactions_in tin ") 
		.append("WHERE tin.is_active = true ");
	
		List<?> list = em.createNativeQuery(sb.toString())
				.getResultList();
		
		List<TransactionInDto> listTrxIn = new ArrayList<TransactionInDto>();
		list.forEach(val -> {
			Object[] data = (Object[]) val;
			TransactionInDto trxIn = new TransactionInDto();
			trxIn.setId(data[0] != null ? data[0].toString() : null);
			trxIn.setCode(data[1] != null ? data[1].toString() : null);
			trxIn.setCheckInDate(data[2] != null ? (Date)data[2] : null);
			trxIn.setCreatedBy(data[3] != null ? data[3].toString() : null);
			trxIn.setCreatedDate(data[4] != null ? ((Timestamp)data[4]).toLocalDateTime() : null);
			trxIn.setUpdatedBy(data[5] != null ? data[5].toString() : null);
			trxIn.setUpdatedDate(data[6] != null ? ((Timestamp)data[6]).toLocalDateTime() : null);
			trxIn.setVersion(data[7] != null ? Long.valueOf(data[7].toString()) : null);
			trxIn.setIsActive(data[8] != null ? (Boolean)data[8] : null);
			listTrxIn.add(trxIn);
		});
		return listTrxIn;
	}

	@Override
	public TransactionInDto getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT tin.id, tin.code, tin.check_in_date, ") 
		.append("tin.created_date, tin.updated_by, tin.updated_date, ") 
		.append("tin.VERSION, tin.is_active ") 
		.append("FROM tbl_transactions_in tin ") 
		.append("WHERE tin.id = (:id)\\:\\:text ") 
		.append("AND tin.is_active = true ");
	
		List<?> list = em.createNativeQuery(sb.toString())
				.setParameter("id", id)
				.getResultList();
		
		TransactionInDto trxIn = new TransactionInDto();
		list.forEach(val -> {
			Object[] data = (Object[]) val;
			trxIn.setId(data[0] != null ? data[0].toString() : null);
			trxIn.setCode(data[1] != null ? data[1].toString() : null);
			trxIn.setCheckInDate(data[2] != null ? (Date)data[2] : null);
			trxIn.setCreatedBy(data[3] != null ? data[3].toString() : null);
			trxIn.setCreatedDate(data[4] != null ? ((Timestamp)data[4]).toLocalDateTime() : null);
			trxIn.setUpdatedBy(data[5] != null ? data[5].toString() : null);
			trxIn.setUpdatedDate(data[6] != null ? ((Timestamp)data[6]).toLocalDateTime() : null);
			trxIn.setVersion(data[7] != null ? Long.valueOf(data[7].toString()) : null);
			trxIn.setIsActive(data[8] != null ? (Boolean)data[8] : null);
		});
		return trxIn;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TransactionIn getIdByEntity(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT tin.* ")
		.append("FROM tbl_transactions_in tin ") 
		.append("WHERE tin.id = (:id)\\:\\:text ") 
		.append("AND tin.is_active = true ");
		
		List<TransactionIn> list = em.createNativeQuery(sb.toString(), TransactionIn.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	@Override
	public void addTransactionIn(TransactionIn transactionIn) throws Exception {
		em.persist(transactionIn);
	}

	
}
