package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.constant.Constants;
import com.utility.Utility;

@Controller
public class DocumentController {
	@Autowired
	private Utility utility;
	
	@RequestMapping(value={"/xxxxxxxx"},method=RequestMethod.POST)
    public ModelAndView submitStockOut(HttpServletRequest request,HttpServletResponse response) throws Exception {
  	  ModelAndView model = new ModelAndView(Constants.DOC_UPLOAD);
      return model;
   }
	
}
