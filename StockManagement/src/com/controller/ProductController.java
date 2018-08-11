package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.constant.Constants;
import com.dto.ProductFormBean;
import com.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	private static final Logger LOGGER = Logger.getLogger(ProductController.class);
	
	@RequestMapping(value={"/submitProdReg"},method=RequestMethod.POST)
	public ModelAndView submitProdReg(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(Constants.PRODUCT_REG);
		try {
			ProductFormBean productBean = new ProductFormBean();
			BeanUtils.populate(productBean, request.getParameterMap());
			productBean = productService.submitProdReg(productBean);
			List<ProductFormBean> returnValues = productService
					.getProductList();
			model.addObject("productList", returnValues);
			model.addObject("productBean", productBean);
			model.addObject("success", "File Submitted Successfully.");
		} catch (Exception e) {
			LOGGER.error("Error while sumitting product registration", e);
			model.addObject("success",
					"Error while Submitting File. Try again later.");
		}
		return model;
	}
	
	@RequestMapping(value={"/getCategoryList"}, method= RequestMethod.GET)
    public @ResponseBody String getCategoryList(@RequestParam("productName") String productName, HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<ProductFormBean> categorylist  = productService.getCategoryList(productName);
		JSONObject ojb = new JSONObject();
		JSONArray arr = new JSONArray(categorylist);
		ojb.put("category", arr);
		return ojb.toString();
   }

}
