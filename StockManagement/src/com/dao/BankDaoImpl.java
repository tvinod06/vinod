package com.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import com.constant.Constants;
import com.dto.BankFormBean;
import com.session.HibernateSession;
import com.valueobject.Bank;

@Transactional
public class BankDaoImpl extends HibernateSession implements BankDao{

	@Override
	public BankFormBean saveBankDtl(BankFormBean bankBean) throws Exception {
		Bank bankVo = new Bank();
		BeanUtils.copyProperties(bankVo, bankBean);
		bankVo.setBankTransactionMstId(System.currentTimeMillis());
		bankVo.setCreatedBy(1L);
		bankVo.setCreatedDate(new Date());
		getSession().saveOrUpdate(bankVo);
		return bankBean;
	}

	@Override
	public Long getMonthlyBankWithDrawAmnt() throws Exception {
		
		Calendar cal = Calendar.getInstance();
		StringBuilder sb = new StringBuilder("select sum(amount) from Bank where transactionType =:transactionType and year(createdDate) = :yearId and month(createdDate) = :monthId ");
		Query query = getSession().createQuery(sb.toString());
		query.setParameter("yearId", cal.get(Calendar.YEAR));
		query.setParameter("monthId", cal.get(Calendar.MONTH));
		query.setParameter("transactionType", Constants.BANK_WITHDRWAL_LOOKUP);		
		List<Object> stockList = query.getResultList();
		
		if(stockList != null && stockList.get(0) !=null){
			return Long.valueOf(stockList.get(0).toString());
		}
		return 0L;
	}

	@Override
	public Long getMonthlyBankDepositAmnt() throws Exception {
		
		Calendar cal = Calendar.getInstance();
		StringBuilder sb = new StringBuilder("select sum(amount) from Bank where transactionType =:transactionType and year(createdDate) = :yearId and month(createdDate) = :monthId ");
		Query query = getSession().createQuery(sb.toString());
		query.setParameter("yearId", cal.get(Calendar.YEAR));
		query.setParameter("monthId", cal.get(Calendar.MONTH));
		query.setParameter("transactionType", Constants.BANK_DEPOSIT_LOOKUP);		
		List<Object> stockList = query.getResultList();
		
		if(stockList != null && stockList.get(0) !=null){
			return Long.valueOf(stockList.get(0).toString());
		}
		return 0L;
	}
	
}