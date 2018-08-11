package com.dto;

import java.util.Date;

public class BankFormBean {
	
	private Long bankTransactionMstId;
	private Long amount;
	private String purpose;
	private Long documentId;
	private Long transactionType;
	private Long category;
	private Date createdDate;
	private Long CreatedBy;
	private Date updatedDate;
	private Long updatedBy;
	private byte[] fileBytes;
	private String file;
	private String fileName;
	private String fileType;

	
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
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
	public byte[] getFileBytes() {
		return fileBytes;
	}
	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	

}
