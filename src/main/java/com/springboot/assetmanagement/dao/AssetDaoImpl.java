package com.springboot.assetmanagement.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.model.Asset;
import com.springboot.assetmanagement.model.Company;
import com.springboot.assetmanagement.model.Invoice;
import com.springboot.assetmanagement.model.Item;
import com.springboot.assetmanagement.model.StatusAsset;

@Repository
public class AssetDaoImpl extends BaseDaoImpl implements AssetDao {

	@Override
	public Asset getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ta.id, ta.code, tc.name AS company, ")
		.append("concat(tim.brand, tim.description) AS item_name, ")
		.append("tsa.name AS status, ti.total_price AS price, ta.expired_date, ta.version ")
		.append("FROM tbl_assets ta ")
		.append("JOIN tbl_items tim ON tim.id = ta.id_item ")
		.append("JOIN tbl_status_assets tsa ON tsa.id = ta.id_status_asset ")
		.append("JOIN tbl_companies tc ON tc.id = ta.id_company ")
		.append("JOIN tbl_invoices ti ON ti.id = ta.id_invoice ")
		.append("WHERE ta.id = (:id)\\:\\:text ") 
		.append("AND ta.is_active = true ");
		
		List<?> list = em.createNativeQuery(sb.toString())
				.setParameter("id", id)
				.getResultList();
		
		Asset asset = new Asset();
		list.forEach(val -> {
			Object[] data = (Object[]) val;
			asset.setId(data[0] != null ? data[0].toString() : null);
			asset.setCode(data[1] != null ? data[1].toString() : null);
			
			Company company = new Company();
			company.setName(data[2] != null ? data[2].toString() : null);
			asset.setCompany(company);
			
			Item item = new Item();
			item.setBrand(data[3] != null ? data[3].toString() : null);
			asset.setItem(item);
			
			StatusAsset statusAsset = new StatusAsset();
			statusAsset.setName(data[4] != null ? data[4].toString() : null);
			asset.setStatusAsset(statusAsset);
			
			Invoice invoice = new Invoice();
			invoice.setTotalPrice(data[5] != null ? (BigDecimal)data[5] : null);
			asset.setInvoice(invoice);
			
			asset.setExpiredDate(data[6] != null ? (Date)data[6] : null);
			asset.setVersion(data[7] != null ? Long.valueOf(data[7].toString()) : null);
		});
		return asset;
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
