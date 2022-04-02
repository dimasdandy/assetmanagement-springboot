package com.springboot.assetmanagement.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springboot.assetmanagement.model.Invoice;

@Repository
public class InvoiceDaoImpl extends BaseDaoImpl implements InvoiceDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Invoice> getAllInvoices() throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT invoice.* ")
		.append("FROM tbl_invoices invoice ") 
		.append("WHERE invoice.is_active = true ");
		
		List<Invoice> list = em.createNativeQuery(sb.toString(), Invoice.class)
				.getResultList();
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Invoice getById(String id) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT invoice.* ")
		.append("FROM tbl_invoices invoice ") 
		.append("WHERE invoice.id = (:id)\\:\\:text ") 
		.append("AND invoice.is_active = true ");
		
		List<Invoice> list = em.createNativeQuery(sb.toString(), Invoice.class)
				.setParameter("id", id)
				.getResultList();
		
		return list.get(0);
	}

	
}
