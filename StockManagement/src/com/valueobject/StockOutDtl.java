package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stock_out_mst_dtl")
@Access(value=AccessType.FIELD)
public class StockOutDtl {

	@Id
	@Column(name="Stock_Out_mst_Dtl_id")
	private Long stockOutMstDtlId;
		
	@Column(name="Stock_Out_mst_id")
	private Long stockOutmstId;
	
	@Column(name="Total_amount")
	private Long totalAmount;

	@Column(name="product_unique_id")
	private String productUniqueId;
	
	@Column(name="Product_name")
	private String productName;
	
	@Column(name="Category")
	private String category;
	
	@Column(name="quantity")
	private Long quantity;
	
	@Column(name="rate_per_unit")
	private Long ratePerUnit;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long CreatedBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;

	

	public Long getStockOutMstDtlId() {
		return stockOutMstDtlId;
	}

	public void setStockOutMstDtlId(Long stockOutMstDtlId) {
		this.stockOutMstDtlId = stockOutMstDtlId;
	}

	public Long getStockOutmstId() {
		return stockOutmstId;
	}

	public void setStockOutmstId(Long stockOutmstId) {
		this.stockOutmstId = stockOutmstId;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getProductUniqueId() {
		return productUniqueId;
	}

	public void setProductUniqueId(String productUniqueId) {
		this.productUniqueId = productUniqueId;
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
