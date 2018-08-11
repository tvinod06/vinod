package com.dto;

import java.io.Serializable;
import java.util.Date;

public class ProductFormBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String productName;
	private String category;
	private String productUniqueId;
	private String description;
	private Integer newProductFlag;
	private String newProductName;
	private Date createdDate;
	private Long CreatedBy;
	private Date updatedDate;
	private Long updatedBy;
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
	public Integer getNewProductFlag() {
		return newProductFlag;
	}
	public void setNewProductFlag(Integer newProductFlag) {
		this.newProductFlag = newProductFlag;
	}
	public String getNewProductName() {
		return newProductName;
	}
	public void setNewProductName(String newProductName) {
		this.newProductName = newProductName;
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
