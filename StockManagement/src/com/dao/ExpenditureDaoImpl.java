package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import com.dto.ExpenditureFormBean;
import com.session.HibernateSession;
import com.valueobject.Expenditure;

@Transactional
public class ExpenditureDaoImpl extends HibernateSession implements ExpenditureDao{

	@Override
	public ExpenditureFormBean saveExpenseDtl(ExpenditureFormBean expenseBean)
			throws Exception {
		Expenditure expense = new Expenditure();
		BeanUtils.copyProperties(expense, expenseBean);
		if(expense.getDocumentId() == null){
			expense.setReciptFlag(0L);
		}else{
			expense.setReciptFlag(1L); 
		}
		expense.setInvestmentMstId(System.currentTimeMillis());
		expense.setCreatedBy(1L);
		if(expenseBean.getExpenseDate() != null){
			expense.setCreatedDate(expenseBean.getExpenseDate());
		}else{
			expense.setCreatedDate(new Date());
		}
		getSession().saveOrUpdate(expense);
		return expenseBean;
	}

	@Override
	public Long getMonthlyExpenditureAmnt() throws Exception {
		
		Calendar cal = Calendar.getInstance();
		StringBuilder sb = new StringBuilder("select sum(totalAmount) from Expenditure where year(createdDate) = :yearId and month(createdDate) = :monthId ");
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
	public List<ExpenditureFormBean> getAllExpDtls(Date frmDate, Date toDate)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String frmDateStr = sdf.format(frmDate);
		String toDateStr = sdf.format(toDate);
		List<ExpenditureFormBean> stockBeanLst = null;
		List<Object[]> stockList = getSession().createQuery("SELECT sum(totalAmount) ,date(createdDate) FROM Expenditure where createdDate >='"+frmDateStr +"' and <='"+ toDateStr+"' group by date(createdDate) order by createdDate asc").getResultList();
		if(stockList != null){
			stockBeanLst = new ArrayList<ExpenditureFormBean>();
			for(Object[] obj : stockList){
				ExpenditureFormBean bean = new ExpenditureFormBean();
				bean.setTotalAmount(Long.parseLong(obj[0].toString()));
				bean.setCreatedDate(sdf.parse(obj[1].toString()));
				stockBeanLst.add(bean);
			}
		}
		return stockBeanLst;
	}
	
}