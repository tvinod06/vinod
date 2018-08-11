package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.dto.ProductFormBean;
import com.session.HibernateSession;
import com.valueobject.Product;

@Transactional
public class ProductDaoImpl extends HibernateSession implements ProductDao{

	@Override
	public ProductFormBean addNewCategory(ProductFormBean productBean) throws Exception {
		Product productVo = new Product();
		BeanUtils.copyProperties(productVo, productBean);
		productVo.setProductDescription(productBean.getDescription());
		productVo.setProductMstId(System.currentTimeMillis());
		getSession().saveOrUpdate(productVo);
		return productBean;
	}

	@Override
	public ProductFormBean addNewProduct(ProductFormBean productBean) throws Exception {
		Product productVo = new Product();
		BeanUtils.copyProperties(productVo, productBean);
		productVo.setProductDescription(productBean.getDescription());
		productVo.setProductMstId(System.currentTimeMillis());
		getSession().save(productVo);
		return productBean;
	}

	@Override
	public List<ProductFormBean> getProductList() throws Exception {
		List<ProductFormBean> formBeanList = null;
		List<String> productList = getSession().createQuery("select distinct(productName) as productName from Product ").getResultList();	
		if (!productList.isEmpty()) {
			formBeanList = new ArrayList<ProductFormBean>();
			for (String bean : productList) {
				ProductFormBean formBean = new ProductFormBean();
				formBean.setProductName(bean);
				formBeanList.add(formBean);
			}
		}
		return formBeanList;
	}

	@Override
	public List<ProductFormBean> getCategoryList(String productName) throws Exception {
		List<ProductFormBean> formBeanList = null;
		List<Object[]> categoryList = getSession().createQuery("select category, productUniqueId from Product where productName = '"+productName+"'").getResultList();	
		if(categoryList != null && !categoryList.isEmpty()){
			formBeanList = new ArrayList<ProductFormBean>();
			for (Object[] bean : categoryList) {
				ProductFormBean formBean = new ProductFormBean();
				formBean.setCategory(bean[0].toString());
				formBean.setProductUniqueId(bean[1].toString());
				formBeanList.add(formBean);
			}
		}
		return formBeanList;
	}

}