package com.springboot.assetmanagement.dao;

import java.util.List;

import com.springboot.assetmanagement.model.Invoice;

public interface InvoiceDao {

	List<Invoice> getAllInvoices() throws Exception;
	
	Invoice getById(String id) throws Exception;
	
}
