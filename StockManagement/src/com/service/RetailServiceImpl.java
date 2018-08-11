package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RetailDao;
import com.dto.RetailFormBean;

@Service
public class RetailServiceImpl implements RetailService{
	
	@Autowired
	private RetailDao retailDao;

	public RetailFormBean submitRetailDtl(RetailFormBean retailBean) throws Exception {
		Long stockMstId = retailDao.saveRetailDtls(retailBean);
		retailBean.setRetailmstId(stockMstId);
		return retailBean;
	}


}
