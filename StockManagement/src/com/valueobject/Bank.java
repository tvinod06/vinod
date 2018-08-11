package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bank_transaction_mst")
@Access(value=AccessType.FIELD)
public class Bank {

	@Id
	@Column(name="bank_transaction_mst_id")
	private Long bankTransactionMstId;
	
	@Column(name="amount")
	private Long amount;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="document_id")
	private Long documentId;
	
	@Column(name="transaction_type")
	private Long transactionType;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long CreatedBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;
	
	

	public Long getBankTransactionMstId() {
		return bankTransactionMstId;
	}

	public void setBankTransactionMstId(Long bankTransactionMstId) {
		this.bankTransactionMstId = bankTransactionMstId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public Long getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Long transactionType) {
		this.transactionType = transactionType;
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
