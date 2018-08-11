package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "document_mst")
@Access(value=AccessType.FIELD)
public class Document {

	@Id
	@Column(name="Document_mst_id")
	private Long documentMstId;
	
	@Column(name="Access_Type")
	private Long accessType;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="category")
	private String category;
	
	@Column(name="document_type")
	private String fileType;
	
	@Column(name="document_name")
	private String fileName;
	
	@Column(name="document")
	private byte[] fileBytes;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long CreatedBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;

	public Long getDocumentMstId() {
		return documentMstId;
	}

	public void setDocumentMstId(Long documentMstId) {
		this.documentMstId = documentMstId;
	}

	public Long getAccessType() {
		return accessType;
	}

	public void setAccessType(Long accessType) {
		this.accessType = accessType;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getFileBytes() {
		return fileBytes;
	}

	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
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
