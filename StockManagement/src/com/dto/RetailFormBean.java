package com.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class RetailFormBean {
	
	private Long retailmstId;
	private String Category;
	private Long quantity;
	private Long ratePerUnit;
	private Long paymentMode;
	private Long totalRetailAmnt;
	private Map<String,Object> productMap;
	private Date createdDate;
	private Long CreatedBy;
	private Date updatedDate;
	private Long updatedBy;
	private List<RetailFormBean> productList;
	private String remarks;
	private String productUniqueId;
	private Long totalAmount;
	private String ProductName;
	private Date retailDate;
	
	public Date getRetailDate() {
		return retailDate;
	}
	public void setRetailDate(Date retailDate) {
		this.retailDate = retailDate;
	}
	public Long getRetailmstId() {
		return retailmstId;
	}
	public void setRetailmstId(Long retailmstId) {
		this.retailmstId = retailmstId;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getRatePerUnit() {
		return ratePerUnit;
	}
	public void setRatePerUnit(Long ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}
	public Long getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(Long paymentMode) {
		this.paymentMode = paymentMode;
	}
	public Long getTotalRetailAmnt() {
		return totalRetailAmnt;
	}
	public void setTotalRetailAmnt(Long totalRetailAmnt) {
		this.totalRetailAmnt = totalRetailAmnt;
	}
	public Map<String, Object> getProductMap() {
		return productMap;
	}
	public void setProductMap(Map<String, Object> productMap) {
		this.productMap = productMap;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Long getCreatedBy() {
		return CreatedBy;
	}
	public void setCreatedBy(Long createdBy) {
		CreatedBy = createdBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public List<RetailFormBean> getProductList() {
		return productList;
	}
	public void setProductList(List<RetailFormBean> productList) {
		this.productList = productList;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getProductUniqueId() {
		return productUniqueId;
	}
	public void setProductUniqueId(String productUniqueId) {
		this.productUniqueId = productUniqueId;
	}
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	
	
	
}
