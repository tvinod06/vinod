package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenditureDao;
import com.dto.ExpenditureFormBean;

@Service
public class ExpenditureServiceImpl implements ExpenditureService{
	
	@Autowired
	private ExpenditureDao expenditureDao;

	@Override
	public ExpenditureFormBean submitExpenseDtl(ExpenditureFormBean expenseBean)
			throws Exception {
		expenseBean = expenditureDao.saveExpenseDtl(expenseBean);
		return expenseBean;
	}



}
