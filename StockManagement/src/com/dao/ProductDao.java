package com.dao;

import java.util.List;

import com.dto.ProductFormBean;

public interface ProductDao {

	ProductFormBean addNewCategory(ProductFormBean productBean) throws Exception;

	ProductFormBean addNewProduct(ProductFormBean productBean) throws Exception;

	List<ProductFormBean> getProductList() throws Exception;

	List<ProductFormBean> getCategoryList(String productName) throws Exception;

}
