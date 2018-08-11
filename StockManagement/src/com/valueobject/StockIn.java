package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_in_mst")
@Access(value=AccessType.FIELD)
public class StockIn {

	@Id
	@Column(name="Stock_In_mst_id")
	private Long stockInmstId;
	
	@Column(name="payment_mode")
	private Long paymentMode;
	
	@Column(name="total_stock_amount")
	private Long totalStockInAmnt;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="In_hand_Amount")
	private Long inHandAmnt;
	
	@Column(name="document_id")
	private Long documentId;
	
	@Column(name="receipt_flag")
	private String receiptFlag;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long CreatedBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;
	
	public Long getStockInmstId() {
		return stockInmstId;
	}
	public void setStockInmstId(Long stockInmstId) {
		this.stockInmstId = stockInmstId;
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
