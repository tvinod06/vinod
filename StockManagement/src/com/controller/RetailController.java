package com.controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.constant.Constants;
import com.dto.RetailFormBean;
import com.service.RetailService;
import com.utility.Utility;

@Controller
public class RetailController {
	@Autowired
	private RetailService retailService;
	@Autowired
	private Utility utility;
	private static final Logger LOGGER = Logger.getLogger(RetailController.class);

	@RequestMapping(value={"/submitRetail"},method=RequestMethod.POST)
	public ModelAndView submitRetailDtl(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(Constants.RETAIL);
		try {
			RetailFormBean retailBean = new RetailFormBean();
			BeanUtils.populate(retailBean, request.getParameterMap());
			String date = request.getParameter("retailDateStr");
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
			if(date != null && !date.equals("")){
				retailBean.setRetailDate(sdf.parse(date));
			}
			retailBean.setProductList(utility.getRetailListFromObject(request
					.getParameter("prodMap")));
			retailBean = retailService.submitRetailDtl(retailBean);
			model.addObject("retailBean", retailBean);
			model.addObject("success", "File Submitted Successfully.");
		} catch (Exception e) {
			LOGGER.error("Error while submitting retail details",e);
			model.addObject("success",
					"Error while Submitting File. Try again later.");
		}
		return model;
	}
	
}
