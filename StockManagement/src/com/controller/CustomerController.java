package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.constant.Constants;
import com.dto.CmnLookupBean;
import com.dto.CustomerFormBean;
import com.dto.ProductFormBean;
import com.service.CustomerService;
import com.service.ProductService;
import com.utility.Utility;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private Utility utility;
	@Autowired
	private ProductService productService;
	private static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	@RequestMapping(value={"/submitCustReg"},method=RequestMethod.POST)
	public ModelAndView submitProdReg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(Constants.custRegistration);
		try {
			CustomerFormBean cutomerBean = new CustomerFormBean();
			BeanUtils.populate(cutomerBean, request.getParameterMap());
			cutomerBean.setCustProductList(utility
					.getCustProdListFrmArray(request.getParameter("prodMap")));
			cutomerBean = customerService.submitCustomerReg(cutomerBean);
			model.addObject("cutomerBean", cutomerBean);
			model.addObject("success", "File Submitted Successfully.");
		} catch (Exception e) {
			LOGGER.error("Error while submitting customer registration", e);
			model.addObject("success",
					"Error while Submitting File. Try again later.");
		}
		return model;
	}
	

	@RequestMapping(value={"/getCustomerDtl"}, method=RequestMethod.GET)
    public @ResponseBody String getCustomerDtl(@RequestParam("customerId") String custId, HttpServletRequest request,HttpServletResponse response) throws Exception {
  	  String jsonObj = customerService.getCustomerDtls(custId);
      return jsonObj;
   }
	
	@RequestMapping(value={"/submitCustModify"},method=RequestMethod.POST)
	public ModelAndView submitCustModify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(
				Constants.custRegistrationModifyAndSearch);
		try {
			CustomerFormBean cutomerBean = new CustomerFormBean();
			BeanUtils.populate(cutomerBean, request.getParameterMap());
			cutomerBean.setCustProductList(utility
					.getCustProdListFrmArray(request.getParameter("prodMap")));
			cutomerBean = customerService.submitCustModify(cutomerBean);
			List<CmnLookupBean> lookupList = utility
					.getLookupNameByParentId(Constants.ORDER_FREQ_PARENT_ID);
			List<CustomerFormBean> cutomersList = customerService
					.getCustomersList();
			List<ProductFormBean> returnValues = productService
					.getProductList();
			model.addObject("productList", returnValues);
			model.addObject("orderFreqList", lookupList);
			model.addObject("cutomersList", cutomersList);
			model.addObject("cutomerBean", cutomerBean);
			model.addObject("success", "File Submitted Successfully.");
		} catch (Exception e) {
			LOGGER.error("Error while submitting customer modification", e);
			model.addObject("success",
					"Error while Submitting File. Try again later.");
		}
		return model;
	}

}
