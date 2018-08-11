package com.dao;

import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.dto.RetailFormBean;
import com.session.HibernateSession;
import com.valueobject.Retail;
import com.valueobject.RetailDtl;

@Transactional
public class RetailDaoImpl extends HibernateSession implements RetailDao{

	@Override
	public Long saveRetailDtls(RetailFormBean retailBean) throws Exception {
		Retail retail = new Retail();
		BeanUtils.copyProperties(retail, retailBean);
		retail.setRetailMstId(System.currentTimeMillis());
		retail.setCreatedBy(-1L);
		if(retailBean.getRetailDate() != null){
			retail.setCreatedDate(retailBean.getRetailDate());
		}else{
			retail.setCreatedDate(new Date());
		}
		retail.setTotalAmount(0L);
		
		for(RetailFormBean stockDtl : retailBean.getProductList()){
			RetailDtl stockInDtl = new RetailDtl();
			BeanUtils.copyProperties(stockInDtl, stockDtl);
			stockInDtl.setRetailMstDtlId(System.currentTimeMillis());
			stockInDtl.setRetailMstId(retail.getRetailMstId());
			stockInDtl.setCreatedBy(-1L);
			if(retailBean.getRetailDate() != null){
				stockInDtl.setCreatedDate(retailBean.getRetailDate());
			}else{
				stockInDtl.setCreatedDate(new Date());
			}
			retail.setTotalAmount(retail.getTotalAmount()+stockInDtl.getTotalAmount());
			getSession().saveOrUpdate(stockInDtl);
			}
		
		getSession().saveOrUpdate(retail);
		return retail.getRetailMstId();
	}
	
}