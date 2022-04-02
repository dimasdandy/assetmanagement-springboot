package com.springboot.assetmanagement.service;

import java.util.List;

import com.springboot.assetmanagement.model.Invoice;

public interface InvoiceService {

	List<Invoice> getAllInvoices() throws Exception;

	Invoice getById(String id) throws Exception;

}
