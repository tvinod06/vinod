package com.controller;

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
import com.dto.ExpenditureFormBean;
import com.service.ExpenditureService;

@Controller
public class ExpenditureController {
	
	@Autowired
	private ExpenditureService expenditureService;
	private static final Logger LOGGER = Logger.getLogger(ExpenditureController.class);

	@RequestMapping(value={"/submitExpenseForm"},method=RequestMethod.POST)
	public ModelAndView submitProdReg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(Constants.INVESTMENT);
		try {
			ExpenditureFormBean expenseBean = new ExpenditureFormBean();
			BeanUtils.populate(expenseBean, request.getParameterMap());
			expenseBean = expenditureService.submitExpenseDtl(expenseBean);
			model.addObject("expenseBean", expenseBean);
			model.addObject("success", "File Submitted Successfully.");
		} catch (Exception e) {
			LOGGER.error("Error while submitting expenditure form", e);
			model.addObject("success",
					"Error while Submitting File. Try again later.");
		}
		return model;
	}
	
}
