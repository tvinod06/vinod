package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "investment_mst")
@Access(value=AccessType.FIELD)
public class Expenditure {
	
	@Id
	@Column(name="investment_mst_id")
	private Long investmentMstId;
	
	@Column(name="investment_type")
	private Long expenseType;
	
	@Column(name="Name_of_product")
	private String productName;
	
	@Column(name="purpose")
	private String purpose;
	
	@Column(name="quantity")
	private Long quantity;
	
	@Column(name="rate_per_unit")
	private Long ratePerUnit;
	
	@Column(name="total_amount")
	private Long totalAmount;
	
	@Column(name="remarks")
	private String remarks;
	
	@Column(name="document_id")
	private Long documentId;
	
	@Column(name="recipt_flag")
	private Long reciptFlag;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long CreatedBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;

	public Long getInvestmentMstId() {
		return investmentMstId;
	}

	public void setInvestmentMstId(Long investmentMstId) {
		this.investmentMstId = investmentMstId;
	}

	public Long getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(Long expenseType) {
		this.expenseType = expenseType;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
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

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public Long getReciptFlag() {
		return reciptFlag;
	}

	public void setReciptFlag(Long reciptFlag) {
		this.reciptFlag = reciptFlag;
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
