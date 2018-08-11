package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import com.dto.StockFormBean;
import com.session.HibernateSession;
import com.valueobject.StockIn;
import com.valueobject.StockInDtl;
import com.valueobject.StockOut;
import com.valueobject.StockOutDtl;

@Transactional
@SuppressWarnings("rawtypes")
public class StockInDaoImpl extends HibernateSession implements StockInDao{

	@Override
	public Long saveStockInDtls(StockFormBean stockBean) throws Exception {
		StockIn stockIn = new StockIn();
		BeanUtils.copyProperties(stockIn, stockBean);
		stockIn.setStockInmstId(System.currentTimeMillis());
		stockIn.setCreatedBy(-1L);
		if(stockBean.getStockInDate() != null){
			stockIn.setCreatedDate(stockBean.getStockInDate());
		}else{
			stockIn.setCreatedDate(new Date());
		}
		getSession().saveOrUpdate(stockIn);
		
		for(StockFormBean stockDtl : stockBean.getProductList()){
			StockInDtl stockInDtl = new StockInDtl();
			BeanUtils.copyProperties(stockInDtl, stockDtl);
			stockInDtl.setStockInMstDtlId(System.currentTimeMillis());
			stockInDtl.setStockInmstId(stockIn.getStockInmstId());
			stockInDtl.setCreatedBy(-1L);
			if(stockBean.getStockInDate() != null){
				stockInDtl.setCreatedDate(stockBean.getStockInDate());
			}else{
				stockInDtl.setCreatedDate(new Date());
			}
			getSession().saveOrUpdate(stockInDtl);
			}
		
		return stockIn.getStockInmstId();
	}

	@Override
	public Long saveStockOutDtls(StockFormBean stockBean) throws Exception {
		StockOut stockOut = new StockOut();
		BeanUtils.copyProperties(stockOut, stockBean);
		stockOut.setStockOutmstId(System.currentTimeMillis());
		stockOut.setCreatedBy(-1L);
		if(stockBean.getStockOutDate() != null){
			stockOut.setCreatedDate(stockBean.getStockOutDate());
		}else{
			stockOut.setCreatedDate(new Date());
		}
		getSession().saveOrUpdate(stockOut);
		
		for(StockFormBean stockDtl : stockBean.getProductList()){
			StockOutDtl stockOutDtl = new StockOutDtl();
			BeanUtils.copyProperties(stockOutDtl, stockDtl);
			stockOutDtl.setStockOutMstDtlId(System.currentTimeMillis());
			stockOutDtl.setStockOutmstId(stockOut.getStockOutmstId());
			stockOutDtl.setCreatedBy(-1L);
			if(stockBean.getStockOutDate() != null){
				stockOutDtl.setCreatedDate(stockBean.getStockOutDate());
			}else{
				stockOutDtl.setCreatedDate(new Date());
			}
			getSession().saveOrUpdate(stockOutDtl);
			}
		
		return stockOut.getStockOutmstId();
	}

	@Override
	public List<StockFormBean> getAllStockInDtls(Date stockDate) throws Exception {
		List<StockFormBean> stockBeanLst = null;
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		List<Object[]> stockList = getSession().createQuery("select productName, category, quantity, ratePerUnit, totalAmount, productUniqueId from StockInDtl where date(createdDate) = '"+sdf.format(stockDate)+"'").getResultList();
		if(stockList != null){
			stockBeanLst = new ArrayList<StockFormBean>();
			for(Object[] obj : stockList){
				StockFormBean bean = new StockFormBean();
				bean.setProductName(obj[0].toString());
				bean.setCategory(obj[1].toString());
				bean.setQuantity(Long.parseLong(obj[2].toString()));
				bean.setRatePerUnit(Long.parseLong(obj[3].toString()));
				bean.setTotalAmount(Long.parseLong(obj[4].toString()));
				bean.setProductUniqueId(obj[5].toString());
				stockBeanLst.add(bean);
			}
		}
		return stockBeanLst;
	}

	@Override
	public List<StockFormBean> getAllStockOutDtls(Date stockDate) throws Exception {
		List<StockFormBean> stockBeanLst = null;
		SimpleDateFormat sdf  = new SimpleDateFormat("yyyy-MM-dd");
		List<Object[]> stockList = getSession().createQuery("select productName, category, quantity, ratePerUnit, totalAmount, productUniqueId from StockOutDtl where date(createdDate) = '"+sdf.format(stockDate)+"'").getResultList();
		if(stockList != null){
			stockBeanLst = new ArrayList<StockFormBean>();
			for(Object[] obj : stockList){
				StockFormBean bean = new StockFormBean();
				bean.setProductName(obj[0].toString());
				bean.setCategory(obj[1].toString());
				bean.setQuantity(Long.parseLong(obj[2].toString()));
				bean.setRatePerUnit(Long.parseLong(obj[3].toString()));
				bean.setTotalAmount(Long.parseLong(obj[4].toString()));
				bean.setProductUniqueId(obj[5].toString());
				stockBeanLst.add(bean);
			}
		}
		return stockBeanLst;
	}

	@Override
	public Long getMonthlyStockInAmnt() throws Exception {
		Calendar cal = Calendar.getInstance();
		StringBuilder sb = new StringBuilder("select sum(totalStockInAmnt) from StockIn where year(createdDate) = :yearId and month(createdDate) = :monthId ");
		Query query = getSession().createQuery(sb.toString());
		query.setParameter("yearId", cal.get(Calendar.YEAR));
		query.setParameter("monthId", cal.get(Calendar.MONTH));
		List<Object> stockList = query.getResultList();
			if(stockList != null && stockList.get(0) !=null){
			return Long.valueOf(stockList.get(0).toString());
		}
		return 0L;
	}

	@Override
	public Long getMonthlyStockOutAmnt() throws Exception {
		Calendar cal = Calendar.getInstance();
		StringBuilder sb = new StringBuilder("select sum(totalStockOutAmount) from StockOut where year(createdDate) = :yearId and month(createdDate) = :monthId ");
		Query query = getSession().createQuery(sb.toString());
		query.setParameter("yearId", cal.get(Calendar.YEAR));
		query.setParameter("monthId", cal.get(Calendar.MONTH));
		List<Object> stockList = query.getResultList();
			if(stockList != null && stockList.get(0) !=null){
			return Long.valueOf(stockList.get(0).toString());
		}
		return 0L;
	}
	
	@Override
	public List<StockFormBean> getAllStockInDtls(Date frmDate, Date toDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String frmDateStr = sdf.format(frmDate);
		String toDateStr = sdf.format(toDate);
		List<StockFormBean> stockBeanLst = null;
		List<Object[]> stockList = getSession().createQuery("SELECT sum(totalStockInAmnt) ,date(createdDate) FROM StockIn where createdDate >='"+frmDateStr +"' and <='"+ toDateStr+"' group by date(createdDate) order by createdDate asc").getResultList();
		if(stockList != null){
			stockBeanLst = new ArrayList<StockFormBean>();
			for(Object[] obj : stockList){
				StockFormBean bean = new StockFormBean();
				bean.setTotalAmount(Long.parseLong(obj[0].toString()));
				bean.setCreatedDate(sdf.parse(obj[1].toString()));
				stockBeanLst.add(bean);
			}
		}
		return stockBeanLst;
	}
	
	@Override
	public List<StockFormBean> getAllStockOutDtls(Date frmDate, Date toDate) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String frmDateStr = sdf.format(frmDate);
		String toDateStr = sdf.format(toDate);
		List<StockFormBean> stockBeanLst = null;
		List<Object[]> stockList = getSession().createQuery("SELECT sum(mst.totalStockOutAmnt) ,date(mst.createdDate), cus.customerName FROM StockOut mst, Customer cus where mst.customerId=cus.cutomerId and createdDate >='"+frmDateStr +"' and <='"+ toDateStr+"' group by date(mst.createdDate) order by mst.createdDate asc").getResultList();
		if(stockList != null){
			stockBeanLst = new ArrayList<StockFormBean>();
			for(Object[] obj : stockList){
				StockFormBean bean = new StockFormBean();
				bean.setTotalAmount(Long.parseLong(obj[0].toString()));
				bean.setCreatedDate(sdf.parse(obj[1].toString()));
				bean.setCustomerName(obj[2].toString());
				stockBeanLst.add(bean);
			}
		}
		return stockBeanLst;
	}
}