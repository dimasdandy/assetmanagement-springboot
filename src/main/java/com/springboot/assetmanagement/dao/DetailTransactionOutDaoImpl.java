package com.springboot.assetmanagement.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.dto.DetailTransactionOutDto;
import com.springboot.assetmanagement.model.DetailTransactionOut;

@Repository
public class DetailTransactionOutDaoImpl extends BaseDaoImpl implements DetailTransactionOutDao {
	
	@Override
	public List<DetailTransactionOutDto> getByTrxOutId(String trxOutId) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT dto.id, tout.id AS parent_trx_id, ta.code AS asset_code, ") 
		.append("concat(tim.brand, ' ', tim.description) AS item_name, ") 
		.append("tsa.name AS status, ti.total_price AS price, ") 
		.append("dto.due_date, dto.created_by, ") 
		.append("dto.created_date, dto.updated_by, dto.updated_date, ") 
		.append("dto.VERSION, dto.is_active ") 
		.append("FROM tbl_detail_transactions_out dto ") 
		.append("JOIN tbl_transactions_out tout ON tout.id = dto.id_transaction_out ") 
		.append("JOIN tbl_assets ta ON ta.id = dto.id_asset ") 
		.append("JOIN tbl_items tim ON tim.id = ta.id_item ") 
		.append("JOIN tbl_status_assets tsa ON tsa.id = ta.id_status_asset ") 
		.append("JOIN tbl_companies tc ON tc.id = ta.id_company ") 
		.append("JOIN tbl_invoices ti ON ti.id = ta.id_invoice ") 
		.append("WHERE dto.id_transaction_out = (:trxOutId)\\:\\:text ") 
		.append("AND dto.is_active = true ");
		
		List<?> list = em.createNativeQuery(sb.toString())
				.setParameter("trxOutId", trxOutId)
				.getResultList();
		
		List<DetailTransactionOutDto> listDetailTrxOut = new ArrayList<DetailTransactionOutDto>();
		list.forEach(val -> {
			DetailTransactionOutDto detailTrxOut = new DetailTransactionOutDto();
			Object[] data = (Object[]) val;
			detailTrxOut.setId(data[0] != null ? data[0].toString() : null);
			detailTrxOut.setParentTrxId(data[1] != null ? data[1].toString() : null);
			detailTrxOut.setAssetCode(data[2] != null ? data[2].toString() : null);
			detailTrxOut.setItemName(data[3] != null ? data[3].toString() : null);
			detailTrxOut.setStatusAsset(data[4] != null ? data[4].toString() : null);
			detailTrxOut.setPrice(data[5] != null ? data[5].toString() : null);
			detailTrxOut.setDueDate(data[6] != null ? (Date)data[6] : null);
			detailTrxOut.setCreatedBy(data[7] != null ? data[7].toString() : null);
			detailTrxOut.setCreatedDate(data[8] != null ? ((Timestamp)data[8]).toLocalDateTime() : null);
			detailTrxOut.setUpdatedBy(data[9] != null ? data[9].toString() : null);
			detailTrxOut.setUpdatedDate(data[10] != null ? ((Timestamp)data[10]).toLocalDateTime() : null);
			detailTrxOut.setVersion(data[11] != null ? Long.valueOf(data[11].toString()) : null);
			detailTrxOut.setIsActive(data[12] != null ? (Boolean)data[12] : null);
			listDetailTrxOut.add(detailTrxOut);
		});
		return listDetailTrxOut;
	}

	@Override
	public void addTransactionOutDetail(DetailTransactionOut detailTransactionOut) throws Exception {
		em.persist(detailTransactionOut);
	}

//	@Override
//	public void insert(Users data) throws Exception {
//		em.persist(data);
//	}

//	@Override
//	public void update(Users data) throws Exception {
//		em.merge(data);
//
//	}

//	@Override
//	public void delete(Long id) throws Exception {
//		String sql = "delete from tb_m_users where id =:id";
//		em.createNativeQuery(sql).setParameter("id", id).executeUpdate();
//	}

//	@Override
//	public List<Users> getAll() throws Exception {
//		String sql = "select u from Users u where isActive = true";
//		List<Users> listObj = em.createQuery(sql, Users.class).getResultList();
//		return listObj;
//	}


}
