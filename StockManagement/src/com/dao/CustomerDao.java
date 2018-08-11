package com.dao;

import java.util.List;

import com.dto.CustomerFormBean;

public interface CustomerDao {

	CustomerFormBean submitCustReg(CustomerFormBean cutomerBean) throws Exception;

	List<CustomerFormBean> getAllCutomersDtls() throws Exception;

	CustomerFormBean getCutomersDtls(String custId) throws Exception;

	List<CustomerFormBean> getCutomersProdDtls(CustomerFormBean custDtl) throws Exception;

	CustomerFormBean updateCustDtls(CustomerFormBean cutomerBean) throws Exception;

}
