package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BankDao;
import com.dto.BankFormBean;

@Service
public class BankServiceImpl implements BankService{
	
	@Autowired
	private BankDao bankDao;
	
	@Override
	public BankFormBean submitBankDtl(BankFormBean bankBean) throws Exception {
		bankBean.setTransactionType(bankBean.getCategory());
		bankBean = bankDao.saveBankDtl(bankBean);
		return bankBean;
	}

}
