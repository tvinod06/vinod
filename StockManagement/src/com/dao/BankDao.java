package com.dao;

import com.dto.BankFormBean;

public interface BankDao {

	BankFormBean saveBankDtl(BankFormBean bankBean) throws Exception;

	Long getMonthlyBankWithDrawAmnt() throws Exception;

	Long getMonthlyBankDepositAmnt() throws Exception;


}
