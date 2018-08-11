package com.service;

import java.util.Date;
import java.util.List;

import com.dto.StockFormBean;

public interface StockInService {

	StockFormBean submitStockInReq(StockFormBean stockBean) throws Exception;

	StockFormBean submitStockOutReq(StockFormBean stockBean) throws Exception;

	List<StockFormBean> getAllStockInDtls(Date stockDate) throws Exception;

	List<StockFormBean> getAllStockOutDtls(Date stockDate) throws Exception;


}
