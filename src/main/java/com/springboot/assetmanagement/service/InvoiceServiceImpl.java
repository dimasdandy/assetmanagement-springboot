package com.springboot.assetmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.InvoiceDao;
import com.springboot.assetmanagement.model.Invoice;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceDao invoiceDao;

	@Override
	public Invoice getById(String id) throws Exception {
		return invoiceDao.getById(id);
	}

	@Override
	public List<Invoice> getAllInvoices() throws Exception {
		return invoiceDao.getAllInvoices();
	}

}
