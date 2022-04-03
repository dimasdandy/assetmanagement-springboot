package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.bind.ValidationException;

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

	@Override
	@Transactional
	public void add(Invoice invoice) throws Exception {
		invoice.setCode(invoice.getCode());
		invoice.setInvoiceDate(invoice.getInvoiceDate());
		invoice.setTotalPrice(invoice.getTotalPrice());
		invoice.setCreatedBy("admin");
		invoice.setCreatedDate(LocalDateTime.now());
		invoice.setVersion(0L);
		invoice.setIsActive(true);
		invoiceDao.add(invoice);
	}

	@Override
	@Transactional
	public void update(Invoice invoice) throws Exception {
		Invoice invoices = getById(invoice.getId());
		if (invoices.getId() == null || invoices.getId().isEmpty()) {
			throw new ValidationException("id cannot be null.");
		}
		invoice.setCode(invoice.getCode());
		invoice.setInvoiceDate(invoice.getInvoiceDate());
		invoice.setTotalPrice(invoice.getTotalPrice());
		invoice.setCreatedBy(invoices.getCreatedBy());
		invoice.setCreatedDate(invoices.getCreatedDate());
		invoice.setUpdatedBy("admin");
		invoice.setUpdatedDate(LocalDateTime.now());
		invoice.setVersion(invoice.getVersion()+1L);
		invoiceDao.update(invoice);		
	}

	@Override
	@Transactional
	public void delete(String id) throws Exception {
		Invoice invoice = new Invoice();
		invoice.setId(id);
		invoiceDao.delete(id);
	}

}
