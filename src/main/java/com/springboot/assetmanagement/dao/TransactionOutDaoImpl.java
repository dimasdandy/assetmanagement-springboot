package com.springboot.assetmanagement.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.dto.TransactionOutDto;
import com.springboot.assetmanagement.model.TransactionOut;

@Repository
public class TransactionOutDaoImpl extends BaseDaoImpl implements TransactionOutDao {

	@Override
	public List<TransactionOutDto> getAllTrxOut() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT tout.id, tout.code, e.nip, e.full_name, ") 
		.append("e.department, tout.check_out_date, tout.created_by, ") 
		.append("tout.created_date, tout.updated_by, tout.updated_date, ") 
		.append("tout.version, tout.is_active ") 
		.append("FROM tbl_transactions_out tout ") 
		.append("JOIN tbl_employees e ON e.id = tout.id_employee ")
		.append("WHERE tout.is_active = true ");
		
		List<?> list = em.createNativeQuery(sb.toString())
				.getResultList();

		List<TransactionOutDto> listTrxOut = new ArrayList<TransactionOutDto>();
		
		list.forEach(val -> {
			TransactionOutDto trxOut = new TransactionOutDto();
			Object[] data = (Object[]) val;
			trxOut.setId(data[0] != null ? data[0].toString() : null);
			trxOut.setCode(data[1] != null ? data[1].toString() : null);
			trxOut.setNip(data[2] != null ? data[2].toString() : null);
			trxOut.setFullName(data[3] != null ? data[3].toString() : null);
			trxOut.setDepartment(data[4] != null ? data[4].toString() : null);
			trxOut.setCheckOutDate(data[5] != null ? (Date)data[5] : null);
			trxOut.setCreatedBy(data[6] != null ? data[6].toString() : null);
			trxOut.setCreatedDate(data[7] != null ? ((Timestamp)data[7]).toLocalDateTime() : null);
			trxOut.setUpdatedBy(data[8] != null ? data[8].toString() : null);
			trxOut.setUpdatedDate(data[9] != null ? ((Timestamp)data[9]).toLocalDateTime() : null);
			trxOut.setVersion(data[10] != null ? Long.valueOf(data[10].toString()) : null);
			trxOut.setIsActive(data[11] != null ? (Boolean)data[11] : null);
			listTrxOut.add(trxOut);
		});
		return listTrxOut;
	}
	
	@Override
	public TransactionOutDto getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT tout.id, tout.code, e.nip, e.full_name, ") 
		.append("e.department, tout.check_out_date, tout.created_by, ") 
		.append("tout.created_date, tout.updated_by, tout.updated_date, ") 
		.append("tout.version, tout.is_active ") 
		.append("FROM tbl_transactions_out tout ") 
		.append("JOIN tbl_employees e ON e.id = tout.id_employee ") 
		.append("WHERE tout.id = (:id)\\:\\:text ") 
		.append("AND tout.is_active = true ");
		
		List<?> list = em.createNativeQuery(sb.toString())
				.setParameter("id", id)
				.getResultList();
		
		TransactionOutDto trxOut = new TransactionOutDto();
		list.forEach(val -> {
			Object[] data = (Object[]) val;
			trxOut.setId(data[0] != null ? data[0].toString() : null);
			trxOut.setCode(data[1] != null ? data[1].toString() : null);
			trxOut.setNip(data[2] != null ? data[2].toString() : null);
			trxOut.setFullName(data[3] != null ? data[3].toString() : null);
			trxOut.setDepartment(data[4] != null ? data[4].toString() : null);
			trxOut.setCheckOutDate(data[5] != null ? (Date)data[5] : null);
			trxOut.setCreatedBy(data[6] != null ? data[6].toString() : null);
			trxOut.setCreatedDate(data[7] != null ? ((Timestamp)data[7]).toLocalDateTime() : null);
			trxOut.setUpdatedBy(data[8] != null ? data[8].toString() : null);
			trxOut.setUpdatedDate(data[9] != null ? ((Timestamp)data[9]).toLocalDateTime() : null);
			trxOut.setVersion(data[10] != null ? Long.valueOf(data[10].toString()) : null);
			trxOut.setIsActive(data[11] != null ? (Boolean)data[11] : null);
		});
		return trxOut;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TransactionOut getIdByEntity(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT tout.* ")
		.append("FROM tbl_transactions_out tout ") 
		.append("WHERE tout.id = (:id)\\:\\:text ") 
		.append("AND tout.is_active = true ");
		
		List<TransactionOut> list = em.createNativeQuery(sb.toString(), TransactionOut.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	@Override
	public void addTransactionOut(TransactionOut transactionOut) throws Exception {
		em.persist(transactionOut);
	}

}
