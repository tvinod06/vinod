package com.dao;

import java.util.Date;
import java.util.List;

import com.dto.ExpenditureFormBean;

public interface ExpenditureDao {

	ExpenditureFormBean saveExpenseDtl(ExpenditureFormBean expenseBean) throws Exception;

	Long getMonthlyExpenditureAmnt() throws Exception;

	List<ExpenditureFormBean> getAllExpDtls(Date frmDate, Date toDate)throws Exception;


}
