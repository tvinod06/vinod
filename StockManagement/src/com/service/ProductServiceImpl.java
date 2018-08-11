package com.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProductDao;
import com.dto.ProductFormBean;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;

	@Override
	public ProductFormBean submitProdReg(ProductFormBean productBean) throws Exception {
		productBean.setCreatedDate(new Date());
		productBean.setCreatedBy(-1L);
		if(productBean.getNewProductFlag() == 0){
			productBean.setProductUniqueId(generateUniqueId(productBean));
			productBean = productDao.addNewCategory(productBean);
		}else{
			productBean.setProductName(productBean.getNewProductName());
			productBean.setProductUniqueId(generateUniqueId(productBean));
			productBean = productDao.addNewProduct(productBean);
		}
		return productBean;
	} 
	
	private String generateUniqueId(ProductFormBean productBean){
		Random r = new Random();
		return "PI-"+productBean.getProductName().substring(0, 3).toUpperCase()+"-"+productBean.getCategory().substring(0,3).toUpperCase()+"-"+r.nextInt(999);
	}

	@Override
	public List<ProductFormBean> getProductList() throws Exception {
		List<ProductFormBean> productList = productDao.getProductList();
		return productList;
	}

	@Override
	public List<ProductFormBean> getCategoryList(String productName) throws Exception {
		List<ProductFormBean> categoryList = productDao.getCategoryList(productName);
		return categoryList;
	}
	

}
