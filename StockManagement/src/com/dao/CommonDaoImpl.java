package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.dto.CmnLookupBean;
import com.dto.ReportFormBean;
import com.session.HibernateSession;

@Transactional
public class CommonDaoImpl extends HibernateSession implements CommonDao{

	@Override
	public List<CmnLookupBean> getLookupNameByParentId(Long parentId)
			throws Exception {
		List<CmnLookupBean> formBeanList = null;
		if(parentId != null){
			List<Object[]> categoryList = getSession().createQuery("select lookupId,lookupName,lookupDesc from CmnLookupMst where parentLookupId = "+parentId).getResultList();	
			if(categoryList != null && !categoryList.isEmpty()){
				formBeanList = new ArrayList<CmnLookupBean>();
				for (Object[] bean : categoryList) {
					CmnLookupBean formBean = new CmnLookupBean();
					formBean.setLookupId(Long.parseLong(bean[0].toString()));
					formBean.setLookupName(bean[1].toString());
					formBean.setLookupDesc(bean[2].toString());
					formBeanList.add(formBean);
				}
			}
		}
		return formBeanList;
	}

	@Override
	public List<ReportFormBean> getAllReportDtls(Date frmDate, Date toDate)
			throws Exception {
		// TODO Auto-generated method stub
		List<ReportFormBean> formBeanList = null;
		StringBuffer  varname1 = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		varname1.append("SELECT stockOutAmount,(case when todayDate is null then todayssDate else todayDate end) as todayDate,customer_name,stockInAmount,expenditure FROM ");
		varname1.append("((SELECT ");
		varname1.append("stockOutAmount,(case when todayDate is null then todaysDate else todayDate end) as todayDate,customer_name,stockInAmount ");
		varname1.append("FROM ");
		varname1.append("( ");
		varname1.append("   SELECT ");
		varname1.append("   sum(mst.total_stock_amount) as stockOutAmount,date(mst.created_dt) as todayDate,cus.customer_name ");
		varname1.append("   FROM stock_out_mst mst,customer_mst cus ");
		varname1.append("   where mst.customer_Id=cus.cutomer_id ");
		varname1.append("   and mst.created_dt >=date('"+sdf.format(frmDate) +"') and mst.created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		varname1.append("   group by date(mst.created_dt),mst.customer_Id ");
		varname1.append("   order by mst.created_dt asc ");
		varname1.append(") ");
		varname1.append("A ");
		varname1.append("left join ");
		varname1.append("( ");
		varname1.append("   SELECT ");
		varname1.append("   sum(total_stock_amount) as stockInAmount,date(created_dt) as todaysDate ");
		varname1.append("   FROM stock_in_mst ");
		varname1.append("   where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		varname1.append("   group by date(created_dt) ");
		varname1.append("   order by created_dt asc ");
		varname1.append(") ");
		varname1.append("B on A.todayDate = B.todaysDate) ");
		varname1.append("union ");
		varname1.append("(SELECT ");
		varname1.append("stockOutAmount,(case when todayDate is null then todaysDate else todayDate end) as todayDate,customer_name,stockInAmount ");
		varname1.append("FROM ");
		varname1.append("( ");
		varname1.append("   SELECT ");
		varname1.append("   sum(mst.total_stock_amount) as stockOutAmount,date(mst.created_dt) as todayDate,cus.customer_name ");
		varname1.append("   FROM stock_out_mst mst,customer_mst cus ");
		varname1.append("   where mst.customer_Id=cus.cutomer_id ");
		varname1.append("   and mst.created_dt >=date('"+sdf.format(frmDate) +"') and mst.created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		varname1.append("   group by date(mst.created_dt),mst.customer_Id ");
		varname1.append("   order by mst.created_dt asc ");
		varname1.append(") ");
		varname1.append("A ");
		varname1.append("right join ");
		varname1.append("( ");
		varname1.append("   SELECT ");
		varname1.append("   sum(total_stock_amount) as stockInAmount,date(created_dt) as todaysDate ");
		varname1.append("   FROM stock_in_mst ");
		varname1.append("   where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		varname1.append("   group by date(created_dt) ");
		varname1.append("   order by created_dt asc ");
		varname1.append(") ");
		varname1.append("B on A.todayDate = B.todaysDate)) G ");
		varname1.append("left join ");
		varname1.append("( ");
		varname1.append("   SELECT ");
		varname1.append("   sum(total_amount) as expenditure,date(created_Dt) as todayssDate ");
		varname1.append("   FROM investment_mst ");
		varname1.append("   where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		varname1.append("   group by date(created_Dt) ");
		varname1.append("   order by created_Dt asc ");
		varname1.append(") ");
		varname1.append("D on G.todayDate = D.todayssDate ");
		varname1.append("union ");
		varname1.append("SELECT stockOutAmount,(case when todayDate is null then todayssDate else todayDate end) as todayDate,customer_name,stockInAmount,expenditure FROM ");
		varname1.append("((SELECT ");
		varname1.append("stockOutAmount,(case when todayDate is null then todaysDate else todayDate end) as todayDate,customer_name,stockInAmount ");
		varname1.append("FROM ");
		varname1.append("( ");
		varname1.append("   SELECT ");
		varname1.append("   sum(mst.total_stock_amount) as stockOutAmount,date(mst.created_dt) as todayDate,cus.customer_name ");
		varname1.append("   FROM stock_out_mst mst,customer_mst cus ");
		varname1.append("   where mst.customer_Id=cus.cutomer_id ");
		varname1.append("   and mst.created_dt >=date('"+sdf.format(frmDate) +"') and mst.created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		varname1.append("   group by date(mst.created_dt),mst.customer_Id ");
		varname1.append("   order by mst.created_dt asc ");
		varname1.append(") ");
		varname1.append("A ");
		varname1.append("left join ");
		varname1.append("( ");
		varname1.append("   SELECT ");
		varname1.append("   sum(total_stock_amount) as stockInAmount,date(created_dt) as todaysDate ");
		varname1.append("   FROM stock_in_mst ");
		varname1.append("   where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		varname1.append("   group by date(created_dt) ");
		varname1.append("   order by created_dt asc ");
		varname1.append(") ");
		varname1.append("B on A.todayDate = B.todaysDate) ");
		varname1.append("union ");
		varname1.append("(SELECT ");
		varname1.append("stockOutAmount,(case when todayDate is null then todaysDate else todayDate end) as todayDate,customer_name,stockInAmount ");
		varname1.append("FROM ");
		varname1.append("( ");
		varname1.append("   SELECT ");
		varname1.append("   sum(mst.total_stock_amount) as stockOutAmount,date(mst.created_dt) as todayDate,cus.customer_name ");
		varname1.append("   FROM stock_out_mst mst,customer_mst cus ");
		varname1.append("   where mst.customer_Id=cus.cutomer_id ");
		varname1.append("   and mst.created_dt >=date('"+sdf.format(frmDate) +"') and mst.created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		varname1.append("   group by date(mst.created_dt),mst.customer_Id ");
		varname1.append("   order by mst.created_dt asc ");
		varname1.append(") ");
		varname1.append("A ");
		varname1.append("right join ");
		varname1.append("( ");
		varname1.append("   SELECT ");
		varname1.append("   sum(total_stock_amount) as stockInAmount,date(created_dt) as todaysDate ");
		varname1.append("   FROM stock_in_mst ");
		varname1.append("   where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		varname1.append("   group by date(created_dt) ");
		varname1.append("   order by created_dt asc ");
		varname1.append(") ");
		varname1.append("B on A.todayDate = B.todaysDate)) G ");
		varname1.append("right join ");
		varname1.append("( ");
		varname1.append("   SELECT ");
		varname1.append("   sum(total_amount) as expenditure,date(created_Dt) as todayssDate ");
		varname1.append("   FROM investment_mst ");
		varname1.append("   where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		varname1.append("   group by date(created_Dt) ");
		varname1.append("   order by created_Dt asc ");
		varname1.append(") ");
		varname1.append("D on G.todayDate = D.todayssDate ");
		varname1.append("order by todayDate asc;");
		
		List<Object[]> stockDtlsList = getSession().createSQLQuery(varname1.toString()).list();
		
		StringBuffer  varname2 = new StringBuffer();
		varname2.append("SELECT sum(Total_amount) FROM retail_mst where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"') group by created_dt ");
		List<Object> retail = getSession().createSQLQuery(varname2.toString()).list();
		
		if(stockDtlsList != null && !stockDtlsList.isEmpty()){
			formBeanList = new ArrayList<ReportFormBean>();
			for (Object[] bean : stockDtlsList) {
				ReportFormBean formBean = new ReportFormBean();
				formBean.setStockOutAmount(bean[0] == null ? 0L : Long.parseLong(bean[0].toString()));
				formBean.setStockInAmount(bean[3] == null ? 0L : Long.parseLong(bean[3].toString()));
				formBean.setTodayDate(bean[1] == null ? null : sdf.parse(bean[1].toString()));
				formBean.setExpenditureAmount(bean[4] == null ? 0L : Long.parseLong(bean[4].toString()));
				formBean.setCustomerName(bean[2] == null ? "" : bean[2].toString());
				formBean.setLiveRate(0L);
				formBeanList.add(formBean);
			}
		}
		return formBeanList;
	}
	
	@Override
	public ReportFormBean getReportFooterDetails(Date frmDate, Date toDate)
			throws Exception {
		
		ReportFormBean bean = new ReportFormBean();
		StringBuffer  varname1 = new StringBuffer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		varname1.append("SELECT sum(total_stock_amount),cus.customer_name FROM stock_out_mst stk ,customer_mst cus where stk.customer_Id = cus.cutomer_id and stk.created_dt >=date('"+sdf.format(frmDate) +"') and stk.created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"') group by customer_Id;");
		List<Object[]> stockOutDtlsList = getSession().createSQLQuery(varname1.toString()).list();
		
		if(!stockOutDtlsList.isEmpty()){
			List<ReportFormBean> beanLst = new ArrayList<ReportFormBean>();
			for(Object[] obj : stockOutDtlsList){
				ReportFormBean stockOut = new ReportFormBean();
				stockOut.setFinalStockOutAmount(obj[0] == null ? 0L : Long.valueOf(obj[0].toString()));
				stockOut.setCustomerName(obj[1] == null ? "" : obj[1].toString());
				beanLst.add(stockOut);
			}
			bean.setReportFormBeanList(beanLst);
		}
		
		StringBuffer  varname2 = new StringBuffer();
		varname2.append("SELECT sum(total_stock_amount) FROM stock_in_mst where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		List<Object> stockInDtl = getSession().createSQLQuery(varname2.toString()).list();
		bean.setFinalStockInAmount(stockInDtl.get(0) == null ? 0L : Long.valueOf(stockInDtl.get(0).toString()));
		
		StringBuffer  varname3 = new StringBuffer();
		varname3.append("SELECT sum(total_amount) FROM investment_mst where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		List<Object> InvestDtl = getSession().createSQLQuery(varname3.toString()).list();
		bean.setFinalInvestmentAmount(InvestDtl.get(0) == null ? 0L : Long.valueOf(InvestDtl.get(0).toString()));
		
		StringBuffer  varname4 = new StringBuffer();
		varname4.append("SELECT sum(Total_amount) FROM retail_mst where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"')");
		List<Object> retail = getSession().createSQLQuery(varname4.toString()).list();
		bean.setFinalRetailAmount(retail.get(0) == null ? 0L : Long.valueOf(retail.get(0).toString()));
		
		return bean;
	}
	
	@Override
	public List<ReportFormBean> getRetailDtls(Date frmDate, Date toDate) throws Exception{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer  varname2 = new StringBuffer();
		varname2.append("SELECT sum(Total_amount),created_dt FROM retail_mst where created_dt >=date('"+sdf.format(frmDate) +"') and created_dt <=date('"+sdf.format(new Date(toDate.getTime() + (1000 * 60 * 60 * 24))) +"') group by created_dt ");
		List<Object[]> stockInDtl = getSession().createSQLQuery(varname2.toString()).list();
		List<ReportFormBean> lst = null;
		if(stockInDtl != null && !stockInDtl.isEmpty()){
			lst = new ArrayList<ReportFormBean>();
			for(Object[] obj: stockInDtl){
				ReportFormBean bean = new ReportFormBean();
				bean.setRetailAmount(obj[0] == null ? 0L : Long.valueOf(obj[0].toString()));
				bean.setTodayDate(sdf.parse(obj[1].toString()));
				lst.add(bean);
			}
		}
		return lst;
	}

}