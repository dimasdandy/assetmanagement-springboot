package com.springboot.assetmanagement.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDaoImpl {

	@PersistenceContext
	protected EntityManager em;
}
