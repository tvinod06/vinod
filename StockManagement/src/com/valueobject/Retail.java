package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retail_mst")
@Access(value=AccessType.FIELD)
public class Retail {

	@Id
	@Column(name="retail_mst_id")
	private Long retailMstId;
	
	@Column(name="payment_mode")
	private Long paymentMode;
	
	@Column(name="total_amount")
	private Long totalAmount;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long CreatedBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;

	public Long getRetailMstId() {
		return retailMstId;
	}

	public void setRetailMstId(Long retailMstId) {
		this.retailMstId = retailMstId;
	}

	public Long getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(Long paymentMode) {
		this.paymentMode = paymentMode;
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
