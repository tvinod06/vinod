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
import com.dto.WorkersFormBean;
import com.service.WorkersService;
import com.utility.Utility;

@Controller
public class WorkersController {
	@Autowired
	private WorkersService workersService;
	@Autowired
	private Utility utility;
	private static final Logger LOGGER = Logger.getLogger(WorkersController.class);

	@RequestMapping(value={"/workersFormSubmit"},method=RequestMethod.POST)
	public ModelAndView submitStockIn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(Constants.WORKERS);
		try {
			WorkersFormBean workerBean = new WorkersFormBean();
			BeanUtils.populate(workerBean, request.getParameterMap());
			workerBean.setWorkersList(utility.getWorkerList(
					request.getParameter("workerList"), workerBean));
			workerBean = workersService.submitWorkersDtl(workerBean);
			model.addObject("workerBean", workerBean);
			model.addObject("success", "File Submitted Successfully.");
		} catch (Exception e) {
			LOGGER.error("Error in saving workers details",e);
			model.addObject("success",
					"Error while Submitting File. Try again later.");
		}
		return model;
	}
	
}
