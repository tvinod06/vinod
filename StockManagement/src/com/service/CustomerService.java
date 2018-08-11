package com.service;

import java.util.List;

import com.dto.CustomerFormBean;


public interface CustomerService {

	CustomerFormBean submitCustomerReg(CustomerFormBean cutomerBean) throws Exception;

	List<CustomerFormBean> getCustomersList() throws Exception;

	String getCustomerDtls(String custId) throws Exception;

	CustomerFormBean submitCustModify(CustomerFormBean cutomerBean) throws Exception;

}
