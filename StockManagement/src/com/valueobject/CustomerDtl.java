package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_mst_dtl")
@Access(value=AccessType.FIELD)
public class CustomerDtl {
	
	@Id
	@Column(name="CUSTOMER_MST_DTL_ID")
	private Long cutomerMstDtlId;
	
	@Column(name="CUSTOMER_MST_ID")
	private Long cutomerMstId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="category")
	private String category;
	
	@Column(name="product_unique_id")
	private String productUniqueId;
	
	@Column(name="scale")
	private String scale;
	
	@Column(name="active_flag")
	private Long activeFlag;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long CreatedBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;

	
	public Long getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Long activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Long getCutomerMstId() {
		return cutomerMstId;
	}

	public void setCutomerMstId(Long cutomerMstId) {
		this.cutomerMstId = cutomerMstId;
	}

	public Long getCutomerMstDtlId() {
		return cutomerMstDtlId;
	}

	public void setCutomerMstDtlId(Long cutomerMstDtlId) {
		this.cutomerMstDtlId = cutomerMstDtlId;
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

	public String getScale() {
		return scale;
	}

	public void setScale(String scale) {
		this.scale = scale;
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
