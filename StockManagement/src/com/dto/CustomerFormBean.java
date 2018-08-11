package com.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CustomerFormBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
	private String category;
	private String productUniqueId;
	private String description;
	private Long cutomerMstId;
	private String cutomerId;
	private Long documentId;
	private String customerName;
	private String scale;
	private String startDate;
	private String endDate;
	private Date fromDate;
	private Date toDate;
	private Long frequency;
	private Date createdDate;
	private Long CreatedBy;
	private Date updatedDate;
	private Long updatedBy;
	private String remarks;
	private List<CustomerFormBean> custProductList;
	private Long activeFlag;
	
	
	public Long getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Long activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public List<CustomerFormBean> getCustProductList() {
		return custProductList;
	}
	public void setCustProductList(List<CustomerFormBean> custProductList) {
		this.custProductList = custProductList;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Long getFrequency() {
		return frequency;
	}
	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductUniqueId() {
		return productUniqueId;
	}
	public void setProductUniqueId(String productUniqueId) {
		this.productUniqueId = productUniqueId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getCutomerMstId() {
		return cutomerMstId;
	}
	public void setCutomerMstId(Long cutomerMstId) {
		this.cutomerMstId = cutomerMstId;
	}
	public String getCutomerId() {
		return cutomerId;
	}
	public void setCutomerId(String cutomerId) {
		this.cutomerId = cutomerId;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getScale() {
		return scale;
	}
	public void setScale(String scale) {
		this.scale = scale;
	}
	
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
		
}
