package com.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class StockFormBean {
	
	private Long stockInmstId;
	private String Category;
	private Long quantity;
	private Long ratePerUnit;
	private Long paymentMode;
	private Long totalStockInAmnt;
	private Long totalStockOutAmount;
	private Map<String,Object> productMap;
	private Date createdDate;
	private Long CreatedBy;
	private Date updatedDate;
	private Long updatedBy;
	private List<StockFormBean> productList;
	private String remarks;
	private Long inHandAmnt;
	private Long documentId;
	private String receiptFlag;
	private String productUniqueId;
	private Long totalAmount;
	private Long bankAmnt;
	private String ProductName;
	private String customerId;
	private String customerName;
	private Date stockOutDate;
	private Date stockInDate;
	
	
	public Date getStockOutDate() {
		return stockOutDate;
	}
	public void setStockOutDate(Date stockOutDate) {
		this.stockOutDate = stockOutDate;
	}
	public Date getStockInDate() {
		return stockInDate;
	}
	public void setStockInDate(Date stockInDate) {
		this.stockInDate = stockInDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public Long getStockInmstId() {
		return stockInmstId;
	}
	public void setStockInmstId(Long stockInmstId) {
		this.stockInmstId = stockInmstId;
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
	public Long getTotalStockInAmnt() {
		return totalStockInAmnt;
	}
	public void setTotalStockInAmnt(Long totalStockInAmnt) {
		this.totalStockInAmnt = totalStockInAmnt;
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
	public List<StockFormBean> getProductList() {
		return productList;
	}
	public void setProductList(List<StockFormBean> productList) {
		this.productList = productList;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getInHandAmnt() {
		return inHandAmnt;
	}
	public void setInHandAmnt(Long inHandAmnt) {
		this.inHandAmnt = inHandAmnt;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	public String getReceiptFlag() {
		return receiptFlag;
	}
	public void setReceiptFlag(String receiptFlag) {
		this.receiptFlag = receiptFlag;
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
	public Long getBankAmnt() {
		return bankAmnt;
	}
	public void setBankAmnt(Long bankAmnt) {
		this.bankAmnt = bankAmnt;
	}
	public Long getTotalStockOutAmount() {
		return totalStockOutAmount;
	}
	public void setTotalStockOutAmount(Long totalStockOutAmount) {
		this.totalStockOutAmount = totalStockOutAmount;
	}
	
	
}
