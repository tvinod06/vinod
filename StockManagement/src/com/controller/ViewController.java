package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.constant.Constants;
import com.dto.CmnLookupBean;
import com.dto.CustomerFormBean;
import com.dto.ProductFormBean;
import com.dto.StockFormBean;
import com.service.CustomerService;
import com.service.ProductService;
import com.service.StockInService;
import com.utility.Utility;

@Controller
public class ViewController {

	@Autowired
	private ProductService productService;
	@Autowired
	private Utility utility;
	@Autowired
	private StockInService stockInService;
	@Autowired
	private CustomerService customerService;
	private static final Logger LOGGER = Logger.getLogger(ViewController.class);
 
	@RequestMapping(value = "/index")
	public ModelAndView index() throws Exception {
		ModelAndView model = new ModelAndView(Constants.INDEX);
		Map<String, Object> display = utility.getHomePageDtls();
		model.addObject("display", display);
		return model;
	}

	@RequestMapping(value = "/stockIn")
	public ModelAndView stockIn() throws Exception {
		// Set View Name of JSP file
		ModelAndView model = new ModelAndView(Constants.STOCK_IN);
		try {
			List<ProductFormBean> returnValues = productService
					.getProductList();
			List<CmnLookupBean> lookupList = utility
					.getLookupNameByParentId(Constants.PYMNT_MODE_PARENT_ID);
			model.addObject("productList", returnValues);
			model.addObject("paymentModeList", lookupList);
		} catch (Exception e) {
			LOGGER.error("Error while fetching stock in details", e);
		}
		return model;
	}

	@RequestMapping(value = "/investment")
	public ModelAndView investment() throws Exception {
		ModelAndView model = new ModelAndView(Constants.INVESTMENT);
		try {
			List<CmnLookupBean> lookupList = utility
					.getLookupNameByParentId(Constants.EXPENSE_PARENT_ID);
			model.addObject("expenseList", lookupList);
		} catch (Exception e) {
			LOGGER.error("Error while fetching investment details", e);
		}
		return model;
	}

	@RequestMapping(value = "/custRegistration")
	public ModelAndView custRegistration() throws Exception {
		ModelAndView model = new ModelAndView(Constants.custRegistration);
		try {
			List<CmnLookupBean> lookupList = utility
					.getLookupNameByParentId(Constants.ORDER_FREQ_PARENT_ID);
			List<ProductFormBean> returnValues = productService
					.getProductList();
			model.addObject("productList", returnValues);
			model.addObject("orderFreqList", lookupList);
		} catch (Exception e) {
			LOGGER.error("Error while fetching customer registration details",
					e);
		}
		return model;
	}

	@RequestMapping(value = "/custRegistrationModifyAndSearch")
	public ModelAndView custRegistrationModifyAndSearch() throws Exception {
		ModelAndView model = new ModelAndView(
				Constants.custRegistrationModifyAndSearch);
		try {
			List<CmnLookupBean> lookupList = utility
					.getLookupNameByParentId(Constants.ORDER_FREQ_PARENT_ID);
			List<CustomerFormBean> cutomersList = customerService
					.getCustomersList();
			List<ProductFormBean> returnValues = productService
					.getProductList();
			model.addObject("productList", returnValues);
			model.addObject("orderFreqList", lookupList);
			model.addObject("cutomersList", cutomersList);
		} catch (Exception e) {
			LOGGER.error("Error while fetching customer modification details",
					e);
		}
		return model;
	}

	@RequestMapping(value = "/miscellaneous")
	public ModelAndView miscellaneous() {
		// Set View Name of JSP file
		ModelAndView model = new ModelAndView(Constants.Miscellaneous);
		return model;
	}

	@RequestMapping(value = "/stockOut")
	public ModelAndView stockOut() throws Exception {
		ModelAndView model = new ModelAndView(Constants.STOCK_OUT);
		try {
			List<ProductFormBean> returnValues = productService
					.getProductList();
			List<CmnLookupBean> lookupList = utility
					.getLookupNameByParentId(Constants.PYMNT_MODE_PARENT_ID);
			List<CustomerFormBean> cutomersList = customerService
					.getCustomersList();
			model.addObject("productList", returnValues);
			model.addObject("cutomersList", cutomersList);
			model.addObject("paymentModeList", lookupList);
		} catch (Exception e) {
			LOGGER.error("Error while fetching stock out details", e);
		}
		return model;
	}

	@RequestMapping(value = "/docUpload")
	public ModelAndView docUpload() throws Exception {
		ModelAndView model = new ModelAndView(Constants.DOC_UPLOAD);
		try {
			List<CmnLookupBean> lookupList = utility
					.getLookupNameByParentId(Constants.DOC_CATEGORY_PARENT_ID);
			model.addObject("categoryList", lookupList);
		} catch (Exception e) {
			LOGGER.error("Error while fetching document details", e);
		}
		return model;
	}

	@RequestMapping(value = "/editStock")
	public ModelAndView editStock(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView(Constants.EDIT_STOCK);
		try {
			String date = request.getParameter("stockDate");
			SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
			Date datee = new Date();
			if(date != null && !date.equals("")){
				datee = sdf.parse(date);
			}
			List<StockFormBean> stockInDtls = stockInService
					.getAllStockInDtls(datee);
			List<StockFormBean> stockOutDtls = stockInService
					.getAllStockOutDtls(datee);
			if (stockInDtls != null && !stockInDtls.isEmpty()) {
				model.addObject("totalStockInAmnt", stockInDtls.get(0)
						.getTotalStockInAmnt());
			} else {
				model.addObject("totalStockInAmnt", 0);
			}
			if (stockOutDtls != null && !stockOutDtls.isEmpty()) {
				model.addObject("totalStockOutAmnt", stockOutDtls.get(0)
						.getTotalStockOutAmount());
			} else {
				model.addObject("totalStockOutAmnt", 0);
			}
			model.addObject("stockOutLst", stockOutDtls);
			model.addObject("stockInLst", stockInDtls);
		} catch (Exception e) {
			LOGGER.error("Error while fetching today stock details", e);
		}
		return model;
	}

	@RequestMapping(value = "/bankDtl")
	public ModelAndView bankDtl() throws Exception {
		ModelAndView model = new ModelAndView(Constants.BANK_DTL);
		List<CmnLookupBean> lookupList = utility
				.getLookupNameByParentId(Constants.TRANSACTION_TYPE_PARENT_ID);
		model.addObject("transactionTypeLst", lookupList);
		return model;
	}

	@RequestMapping(value = "/retail")
	public ModelAndView retailDtl() throws Exception {
		// Set View Name of JSP file
		ModelAndView model = new ModelAndView(Constants.RETAIL);
		try {
			List<ProductFormBean> returnValues = productService
					.getProductList();
			List<CmnLookupBean> lookupList = utility
					.getLookupNameByParentId(Constants.PYMNT_MODE_PARENT_ID);
			model.addObject("productList", returnValues);
			model.addObject("paymentModeList", lookupList);
		} catch (Exception e) {
			LOGGER.error("Error while fetching retail details", e);
		}
		return model;
	}

	@RequestMapping(value = "/workers")
	public ModelAndView workers() {
		// Set View Name of JSP file
		ModelAndView model = new ModelAndView(Constants.WORKERS);
		return model;
	}

	@RequestMapping(value = "/productReg")
	public ModelAndView productReg() throws Exception {
		ModelAndView model = new ModelAndView(Constants.PRODUCT_REG);
		try {
			List<ProductFormBean> returnValues = productService
					.getProductList();
			model.addObject("productList", returnValues);
		} catch (Exception e) {
			LOGGER.error("Error while fetching product registration details", e);
		}
		return model;
	}

	@RequestMapping(value = "/test")
	public ModelAndView test() throws Exception {
		// Set View Name of JSP file
		ModelAndView model = new ModelAndView(Constants.TEST);
		return model;
	}
	
	@RequestMapping(value = "/getReport")
	public ModelAndView getReport() throws Exception {
		// Set View Name of JSP file
		ModelAndView model = new ModelAndView(Constants.GET_REPORT);
		return model;
	}

	@RequestMapping(value = "/getReportDtls")
	public ModelAndView getReportDtls(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// Set View Name of JSP file
		ModelAndView model = new ModelAndView(Constants.GET_REPORT);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date frmDate = sdf.parse(request.getParameter("frmDate"));
		Date toDate = sdf.parse(request.getParameter("toDate"));
		String orientation = request.getParameter("pageOrientation");
		String path = utility.generateReports(frmDate, toDate, orientation);
		model.addObject("path", path);
		return model;
	}
}
