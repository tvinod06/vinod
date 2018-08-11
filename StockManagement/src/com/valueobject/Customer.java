package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_mst")
@Access(value=AccessType.FIELD)
public class Customer {
	
	@Id
	@Column(name="CUSTOMER_MST_ID")
	private Long cutomerMstId;
	
	@Column(name="cutomer_id")
	private String cutomerId;
	
	@Column(name="document_id")
	private Long documentId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="frequency")
	private Long frequency;

	@Column(name="remarks")
	private String remarks;
	
	@Column(name="from_date")
	private Date fromDate;
	
	@Column(name="to_date")
	private Date toDate;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long CreatedBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;
	
	

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Long getFrequency() {
		return frequency;
	}

	public void setFrequency(Long frequency) {
		this.frequency = frequency;
	}
	
	
}
