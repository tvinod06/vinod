package com.service;

import java.util.List;

import com.dto.ProductFormBean;


public interface ProductService {

	ProductFormBean submitProdReg(ProductFormBean productBean) throws Exception;

	List<ProductFormBean> getProductList() throws Exception;

	List<ProductFormBean> getCategoryList(String productName) throws Exception;

}
