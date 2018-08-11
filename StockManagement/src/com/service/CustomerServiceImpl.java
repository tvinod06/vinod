package com.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDao;
import com.dto.CustomerFormBean;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;

	@Override
	public CustomerFormBean submitCustomerReg(CustomerFormBean cutomerBean) throws Exception {
		cutomerBean.setCutomerId(generateCustomerUniqueId(cutomerBean));
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		if(cutomerBean.getStartDate() != null && cutomerBean.getStartDate() != ""){
			cutomerBean.setFromDate(sdf.parse(cutomerBean.getStartDate()));
		}
		if(cutomerBean.getEndDate() != null && cutomerBean.getEndDate() != ""){
			cutomerBean.setToDate(sdf.parse(cutomerBean.getEndDate()));
		}
		cutomerBean = customerDao.submitCustReg(cutomerBean);
		return cutomerBean;
	}

	private String generateCustomerUniqueId(CustomerFormBean bean){
		Random r = new Random();
		String custId = "CI-"+bean.getCustomerName().substring(0,2).toUpperCase()+"-F"+bean.getFrequency()+"-"+r.nextInt(999);
		return custId;
	}

	@Override
	public List<CustomerFormBean> getCustomersList() throws Exception {
		List<CustomerFormBean> list = customerDao.getAllCutomersDtls();
		return list;
	}

	@Override
	public String getCustomerDtls(String custId) throws Exception {

		CustomerFormBean custDtl = customerDao.getCutomersDtls(custId);
		JSONObject jObj = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(custDtl.getFromDate() != null){
			jObj.put("fromDate", sdf.format(custDtl.getFromDate()));
		}
		if(custDtl.getToDate() != null){
			jObj.put("toDate", sdf.format(custDtl.getToDate()));
		}
		jObj.put("frequency", custDtl.getFrequency());
		
		List<CustomerFormBean> custProdDtl = customerDao.getCutomersProdDtls(custDtl);
		
		if(custProdDtl != null && !custProdDtl.isEmpty()){
			jObj.put("custProdDtls", custProdDtl);
		}
		
		return jObj.toString();
	}

	@Override
	public CustomerFormBean submitCustModify(CustomerFormBean cutomerBean)
			throws Exception {
		cutomerBean.setCutomerId(cutomerBean.getCustomerName());
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		if(cutomerBean.getStartDate() != null && cutomerBean.getStartDate() != ""){
			cutomerBean.setFromDate(sdf.parse(cutomerBean.getStartDate()));
		}
		if(cutomerBean.getEndDate() != null && cutomerBean.getEndDate() != ""){
			cutomerBean.setToDate(sdf.parse(cutomerBean.getEndDate()));
		}
		cutomerBean = customerDao.updateCustDtls(cutomerBean);
		return cutomerBean;
	}
}
