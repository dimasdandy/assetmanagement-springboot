package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.Invoice;

public interface InvoiceService {

	List<Invoice> getAllInvoices() throws Exception;

	Invoice getById(String id) throws Exception;
	
	void add(Invoice invoice) throws Exception;

	void update(Invoice invoice) throws Exception;
	
	void delete(String id) throws Exception;
}
