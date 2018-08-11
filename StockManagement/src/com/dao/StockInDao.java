package com.dao;

import java.util.Date;
import java.util.List;

import com.dto.StockFormBean;

public interface StockInDao {

	Long saveStockInDtls(StockFormBean stockBean) throws Exception;

	Long saveStockOutDtls(StockFormBean stockBean) throws Exception;

	List<StockFormBean> getAllStockInDtls(Date stockDate) throws Exception;

	List<StockFormBean> getAllStockOutDtls(Date stockDate) throws Exception;

	Long getMonthlyStockInAmnt() throws Exception;

	Long getMonthlyStockOutAmnt() throws Exception;

	List<StockFormBean> getAllStockInDtls(Date frmDate, Date toDate)
			throws Exception;

	List<StockFormBean> getAllStockOutDtls(Date frmDate, Date toDate)
			throws Exception;

}
