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
import com.dto.StockFormBean;
import com.service.ProductService;
import com.service.StockInService;
import com.utility.Utility;

@Controller
public class StockInController {
	@Autowired
	private StockInService stockInService;
	@Autowired
	private Utility utility;
	@Autowired
	private ProductService productService;
	
	private static final Logger LOGGER = Logger.getLogger(StockInController.class);

	@RequestMapping(value={"/submitStockIn"},method=RequestMethod.POST)
	public ModelAndView submitStockIn(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(Constants.STOCK_IN);
		try {
			StockFormBean stockBean = new StockFormBean();
			BeanUtils.populate(stockBean, request.getParameterMap());
			String date = request.getParameter("stockInDateStr");
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
			if(date != null && !date.equals("")){
				stockBean.setStockInDate(sdf.parse(date));
			}
			stockBean.setProductList(utility.getBeanListFromObject(request
					.getParameter("prodMap")));
			stockBean = stockInService.submitStockInReq(stockBean);
			model.addObject("stockBean", stockBean);
			model.addObject("success", "File Submitted Successfully.");
			
		} catch (Exception e) {
			LOGGER.error("Error while submitting Stock In dtls ",e);
			model.addObject("success",
					"Error while Submitting File. Try again later.");
		}
		return model;
	}
	
	@RequestMapping(value={"/stockOutSubmit"},method=RequestMethod.POST)
	public ModelAndView submitStockOut(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(Constants.STOCK_OUT);
		try {
			StockFormBean stockBean = new StockFormBean();
			BeanUtils.populate(stockBean, request.getParameterMap());
			String date = request.getParameter("stockOutDateStr");
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
			if(date != null && !date.equals("")){
				stockBean.setStockOutDate(sdf.parse(date));
			}
			stockBean.setProductList(utility.getBeanListFromObject(request
					.getParameter("prodMap")));
			stockBean = stockInService.submitStockOutReq(stockBean);
			model.addObject("stockBean", stockBean);
			model.addObject("success", "File Submitted Successfully.");
		} catch (Exception e) {
			LOGGER.error("Error while submitting Stock out dtls ",e);
			model.addObject("success",
					"Error while Submitting File. Try again later.");
		}
		return model;
	}
	
}
