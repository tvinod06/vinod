package com.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import com.constant.Constants;
import com.dto.WorkersFormBean;
import com.session.HibernateSession;
import com.valueobject.Workers;
import com.valueobject.WorkersDtl;

@Transactional
public class WorkersDaoImpl extends HibernateSession implements WorkersDao{

	@Override
	public Long saveWorkersDtls(WorkersFormBean retailBean) throws Exception {
		Workers retail = new Workers();
		BeanUtils.copyProperties(retail, retailBean);
		retail.setWorkerMstId(System.currentTimeMillis());
		retail.setActiveFlag(Constants.ACTV_FLAG);
		retail.setNumberOfWorkers(Long.valueOf(retailBean.getWorkersList().size()));
		retail.setTotalAmount(retailBean.getTotalAmount());
		retail.setCreatedBy(-1L);
		retail.setCreatedDate(new Date());
		getSession().saveOrUpdate(retail);
		
		for(WorkersFormBean stockDtl : retailBean.getWorkersList()){
			WorkersDtl stockInDtl = new WorkersDtl();
			BeanUtils.copyProperties(stockInDtl, stockDtl);
			stockInDtl.setWorkersMstDtlId(System.currentTimeMillis());
			stockInDtl.setActiveFlag(Constants.ACTV_FLAG);
			stockInDtl.setWorkerMstId(retail.getWorkerMstId());
			stockInDtl.setCreatedBy(-1L);
			stockInDtl.setCreatedDate(new Date());
			getSession().saveOrUpdate(stockInDtl);
			}
		
		return retail.getWorkerMstId();
	}

	@Override
	public Long getMonthlyWorkersAmnt() throws Exception {
		
		Calendar cal = Calendar.getInstance();
		StringBuilder sb = new StringBuilder("select sum(totalAmount) from Workers where year(createdDate) = :yearId and month(createdDate) = :monthId ");
		Query query = getSession().createQuery(sb.toString());
		query.setParameter("yearId", cal.get(Calendar.YEAR));
		query.setParameter("monthId", cal.get(Calendar.MONTH));
		List<Object> stockList = query.getResultList();
		
		if(stockList != null && stockList.get(0) !=null){
			return Long.valueOf(stockList.get(0).toString());
		}
		return 0L;
	}

}