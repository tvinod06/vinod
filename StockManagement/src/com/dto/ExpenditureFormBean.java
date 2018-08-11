package com.dto;

import java.util.Date;

public class ExpenditureFormBean {
	
	private Long expenseType;
	private String productName;
	private String purpose;
	private Long quantity;
	private Long ratePerUnit;
	private Long totalAmount;
	private String remarks;
	private Long documentId;
	private Date createdDate;
	private Long CreatedBy;
	private Date updatedDate;
	private Long updatedBy;
	private Date expenseDate;
	
	
	public Date getExpenseDate() {
		return expenseDate;
	}
	public void setExpenseDate(Date expenseDate) {
		this.expenseDate = expenseDate;
	}
	public Long getExpenseType() {
		return expenseType;
	}
	public void setExpenseType(Long expenseType) {
		this.expenseType = expenseType;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
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
	public Long getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
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
	
	

}
