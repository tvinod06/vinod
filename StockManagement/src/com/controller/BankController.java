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
import com.dto.BankFormBean;
import com.service.BankService;

@Controller
public class BankController {
	
	@Autowired
	private BankService bankService;
	private static final Logger LOGGER = Logger.getLogger(BankController.class);

	@RequestMapping(value={"/submitBankForm"},method=RequestMethod.POST)
	public ModelAndView submitProdReg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView model = new ModelAndView(Constants.BANK_DTL);
		try {
			BankFormBean bankBean = new BankFormBean();
			BeanUtils.populate(bankBean, request.getParameterMap());
			bankBean = bankService.submitBankDtl(bankBean);
			model.addObject("bankBean", bankBean);
			model.addObject("success", "File Submitted Successfully.");
		} catch (Exception e) {
			LOGGER.error("Error in saving bank transactions.", e);
			model.addObject("success", "Error while Submitting File. Try again later.");
		}
		return model;
	}
	
}
