package com.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import com.constant.Constants;
import com.dto.CustomerFormBean;
import com.session.HibernateSession;
import com.valueobject.Customer;
import com.valueobject.CustomerDtl;

@Transactional
public class CustomerDaoImpl extends HibernateSession implements CustomerDao{

	@Override
	public CustomerFormBean submitCustReg(CustomerFormBean cutomerBean)
			throws Exception {
		Customer custVo = new Customer();
		BeanUtils.copyProperties(custVo, cutomerBean);
		custVo.setCutomerMstId(System.currentTimeMillis());
		custVo.setCreatedBy(-1L);
		custVo.setCreatedDate(new Date());
		getSession().save(custVo);
		
		for(CustomerFormBean bean : cutomerBean.getCustProductList()){
			CustomerDtl custDtl = new CustomerDtl();
			BeanUtils.copyProperties(custDtl, bean);
			custDtl.setActiveFlag(Constants.ACTV_FLAG);
			custDtl.setCutomerMstDtlId(System.currentTimeMillis());
			custDtl.setCutomerMstId(custVo.getCutomerMstId());
			//custDtl.setCreatedBy(-1L);
			custDtl.setCreatedDate(new Date());
			getSession().save(custDtl);
		}
		return cutomerBean;
	}

	@Override
	public List<CustomerFormBean> getAllCutomersDtls() throws Exception {
		List<CustomerFormBean> formBeanList = null;
		List<Object[]> custList = getSession().createQuery("select customerName,cutomerId from Customer").getResultList();	
		if (!custList.isEmpty()) {
			formBeanList = new ArrayList<CustomerFormBean>();
			for (Object[] bean : custList) {
				CustomerFormBean formBean = new CustomerFormBean();
				formBean.setCustomerName(bean[0].toString());
				formBean.setCutomerId(bean[1].toString());
				formBeanList.add(formBean);
			}
		}
		return formBeanList;
	}

	@Override
	public CustomerFormBean getCutomersDtls(String custId) throws Exception {
		Customer customer = (Customer) getSession().createQuery("select c from Customer c where cutomerId = '"+custId+"'").getResultList().get(0);
		CustomerFormBean bean = new CustomerFormBean();
		BeanUtils.copyProperties(bean, customer);
		return bean;
	}

	@Override
	public List<CustomerFormBean> getCutomersProdDtls(CustomerFormBean custDtl) throws Exception{

		List<CustomerDtl> customerProdDtl = getSession().createQuery("select c from CustomerDtl c where activeFlag=1 and cutomerMstId = "+custDtl.getCutomerMstId()).getResultList();
		List<CustomerFormBean> formBeanList = null;
		if(!customerProdDtl.isEmpty()){
			formBeanList = new ArrayList<CustomerFormBean>();
			for(CustomerDtl bean : customerProdDtl){
				CustomerFormBean customer = new CustomerFormBean();
				BeanUtils.copyProperties(customer, bean);
				formBeanList.add(customer);
			}
		}
		return formBeanList;
	}

	@Override
	public CustomerFormBean updateCustDtls(CustomerFormBean cutomerBean) throws Exception {
		Query query = getSession().createQuery("update Customer set "+
			"  fromDate= :fromDate" + " ,toDate= :toDate "+ ", documentId = :docId "+ " ,frequency = :frequency "
				+" , updatedDate = :date "+" , updatedBy= :updatedBy "
			+ " where cutomerId = :customerId");
		query.setParameter("fromDate", cutomerBean.getFromDate());
		query.setParameter("toDate", cutomerBean.getToDate());
		query.setParameter("docId", cutomerBean.getDocumentId());
		query.setParameter("frequency", cutomerBean.getFrequency());
		query.setParameter("date", new Date());
		query.setParameter("updatedBy", -1L);
		query.setParameter("customerId", cutomerBean.getCutomerId());
		int result = query.executeUpdate();
		
		if(result != 0){
			CustomerFormBean formBEan = getCutomersDtls(cutomerBean.getCutomerId());
			inActiveAllCustProdDtl(formBEan);
			for(CustomerFormBean formBean: cutomerBean.getCustProductList()){
				CustomerFormBean bean = getCustProdDtl(formBean);
				if(bean == null){
					formBean.setCutomerMstId(formBEan.getCutomerMstId());
					addCustomerDtl(formBean);
				}else{
					updateCustomerDtl(formBean);
				}
			}
		}
		return cutomerBean;
	}
	
	public void inActiveAllCustProdDtl(CustomerFormBean cutomerBean){
		Query query1 = getSession().createQuery("update CustomerDtl set "+" activeFlag = :activeFlag "
					+" , updatedDate =:date "+" , updatedBy= :updatedBy "
				+ " where cutomerMstId = :cutomerMstId");
		query1.setParameter("activeFlag",Constants.INACTV_FLAG);
		query1.setParameter("date", new Date());
		query1.setParameter("updatedBy", -1L);
		query1.setParameter("cutomerMstId", cutomerBean.getCutomerMstId());
		query1.executeUpdate();
	}
	
	public void updateCustomerDtl(CustomerFormBean cutomerBean){
		Query query1 = getSession().createQuery("update CustomerDtl set "+
				"  scale= :scale" + " ,activeFlag = :activeFlag "
					+" , updatedDate = :date "+" , updatedBy= :updatedBy "
				+ " where productUniqueId = :productUniqueId");
		query1.setParameter("scale", cutomerBean.getScale());
		query1.setParameter("activeFlag",Constants.ACTV_FLAG);
		query1.setParameter("date", new Date());
		query1.setParameter("updatedBy", -1L);
		query1.setParameter("productUniqueId", cutomerBean.getProductUniqueId());
		query1.executeUpdate();
	}
	
	public CustomerFormBean addCustomerDtl(CustomerFormBean cutomerBean) throws Exception {
		CustomerDtl custDtl = new CustomerDtl();
		BeanUtils.copyProperties(custDtl, cutomerBean);
		custDtl.setActiveFlag(Constants.ACTV_FLAG);
		custDtl.setCutomerMstDtlId(System.currentTimeMillis());
		custDtl.setCutomerMstId(cutomerBean.getCutomerMstId());
		custDtl.setCreatedBy(-1L);
		custDtl.setCreatedDate(new Date());
		getSession().save(custDtl);
		return cutomerBean;
	}
	
	public CustomerFormBean getCustProdDtl(CustomerFormBean custDtl) throws Exception{

		List<Object> prodObj = getSession().createQuery("select c from CustomerDtl c where productUniqueId = '"+custDtl.getProductUniqueId()+"'").getResultList();
		CustomerFormBean formBeanList = null;
		if(!prodObj.isEmpty()){
			formBeanList = new CustomerFormBean();
			CustomerDtl bean = (CustomerDtl) prodObj.get(0);
			BeanUtils.copyProperties(formBeanList, bean);
		}
		return formBeanList;
	}
}
