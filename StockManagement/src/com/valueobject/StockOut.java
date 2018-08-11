package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_out_mst")
@Access(value=AccessType.FIELD)
public class StockOut {

	@Id
	@Column(name="Stock_Out_mst_Id")
	private Long stockOutmstId;
	
	@Column(name="payment_mode")
	private Long paymentMode;
	
	@Column(name="total_stock_amount")
	private Long totalStockOutAmount;
	
	@Column(name="customer_Id")
	private String customerId;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="document_id")
	private Long documentId;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long CreatedBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;
	
	
	public Long getStockOutmstId() {
		return stockOutmstId;
	}
	public void setStockOutmstId(Long stockOutmstId) {
		this.stockOutmstId = stockOutmstId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Long getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(Long paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	public Long getTotalStockOutAmount() {
		return totalStockOutAmount;
	}
	public void setTotalStockOutAmount(Long totalStockOutAmount) {
		this.totalStockOutAmount = totalStockOutAmount;
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
