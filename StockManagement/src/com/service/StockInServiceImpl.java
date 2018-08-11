package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.StockInDao;
import com.dto.StockFormBean;

@Service
public class StockInServiceImpl implements StockInService{
	
	@Autowired
	private StockInDao stockInDao;

	@Override
	public StockFormBean submitStockInReq(StockFormBean stockBean) throws Exception {
		Long stockMstId = stockInDao.saveStockInDtls(stockBean);
		stockBean.setStockInmstId(stockMstId);
		return stockBean;
	}

	@Override
	public StockFormBean submitStockOutReq(StockFormBean stockBean) throws Exception {
		Long stockMstId = stockInDao.saveStockOutDtls(stockBean);
		stockBean.setStockInmstId(stockMstId);
		return stockBean;
	}

	@Override
	public List<StockFormBean> getAllStockInDtls(Date stockDate) throws Exception {
		List<StockFormBean> stockInDtls = stockInDao.getAllStockInDtls(stockDate);
		Long totalStockInAmnt = 0L;
		if(stockInDtls != null && !stockInDtls.isEmpty()){
			for(StockFormBean bean : stockInDtls){
				totalStockInAmnt = totalStockInAmnt + bean.getTotalAmount();
			}
			stockInDtls.get(0).setTotalStockInAmnt(totalStockInAmnt);
		}
		return stockInDtls;
	}

	@Override
	public List<StockFormBean> getAllStockOutDtls(Date stockDate) throws Exception {
		List<StockFormBean> stockOutDtls = stockInDao.getAllStockOutDtls(stockDate);
		Long totalStockOutAmnt = 0L;
		if(stockOutDtls != null && !stockOutDtls.isEmpty()){
			for(StockFormBean bean : stockOutDtls){
				totalStockOutAmnt = totalStockOutAmnt + bean.getTotalAmount();
			}
			stockOutDtls.get(0).setTotalStockOutAmount(totalStockOutAmnt);
		}
		return stockOutDtls;
	}


}
