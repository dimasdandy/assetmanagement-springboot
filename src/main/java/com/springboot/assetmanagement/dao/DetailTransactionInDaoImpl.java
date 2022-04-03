package com.springboot.assetmanagement.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.dto.DetailTransactionInDto;
import com.springboot.assetmanagement.model.DetailTransactionIn;

@Repository
public class DetailTransactionInDaoImpl extends BaseDaoImpl implements DetailTransactionInDao {
	
	@Override
	public List<DetailTransactionInDto> getByTrxInId(String trxInId) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT dti.id, tin.id AS parent_trx_id, ta.code AS asset_code, ")
		.append("concat(tim.brand, tim.description) AS item_name, tac.name AS asset_condition, ")
		.append("tsa.name AS status, ti.total_price AS price, dti.created_by, ")
		.append("dti.created_date, dti.updated_by, dti.updated_date, ")
		.append("dti.VERSION, dti.is_active ")
		.append("FROM tbl_detail_transactions_in dti ")
		.append("JOIN tbl_transactions_in tin ON tin.id = dti.id_transaction_in ")
		.append("JOIN tbl_asset_condition tac ON tac.id  = dti.id_asset_condition ")
		.append("JOIN tbl_assets ta ON ta.id = dti.id_asset ")
		.append("JOIN tbl_items tim ON tim.id = ta.id_item ")
		.append("JOIN tbl_status_assets tsa ON tsa.id = ta.id_status_asset ")
		.append("JOIN tbl_invoices ti ON ti.id = ta.id_invoice ")
		.append("WHERE dti.id_transaction_in = (:trxInId)\\:\\:text ") 
		.append("AND dti.is_active = true ");
		
		List<?> list = em.createNativeQuery(sb.toString())
				.setParameter("trxInId", trxInId)
				.getResultList();
		
		List<DetailTransactionInDto> listDetailTrxIn = new ArrayList<DetailTransactionInDto>();
		list.forEach(val -> {
			DetailTransactionInDto detailTrxIn = new DetailTransactionInDto();
			Object[] data = (Object[]) val;
			detailTrxIn.setId(data[0] != null ? data[0].toString() : null);
			detailTrxIn.setParentTrxId(data[1] != null ? data[1].toString() : null);
			detailTrxIn.setAssetCode(data[2] != null ? data[2].toString() : null);
			detailTrxIn.setItemName(data[3] != null ? data[3].toString() : null);
			detailTrxIn.setAssetCondition(data[4] != null ? data[4].toString() : null);
			detailTrxIn.setStatusAsset(data[5] != null ? data[5].toString() : null);
			detailTrxIn.setPrice(data[6] != null ? data[6].toString() : null);
			detailTrxIn.setCreatedBy(data[7] != null ? data[7].toString() : null);
			detailTrxIn.setCreatedDate(data[8] != null ? ((Timestamp)data[8]).toLocalDateTime() : null);
			detailTrxIn.setUpdatedBy(data[9] != null ? data[9].toString() : null);
			detailTrxIn.setUpdatedDate(data[10] != null ? ((Timestamp)data[10]).toLocalDateTime() : null);
			detailTrxIn.setVersion(data[11] != null ? Long.valueOf(data[11].toString()) : null);
			detailTrxIn.setIsActive(data[12] != null ? (Boolean)data[12] : null);
			listDetailTrxIn.add(detailTrxIn);
		});
		return listDetailTrxIn;
	}

	@Override
	public void addTransactionInDetail(DetailTransactionIn detailTransactionIn) throws Exception {
		em.persist(detailTransactionIn);
	}

}
