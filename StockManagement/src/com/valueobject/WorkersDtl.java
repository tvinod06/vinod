package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workers_mst_dtl")
@Access(value=AccessType.FIELD)
public class WorkersDtl {

	@Id
	@Column(name="WORKERS_MST_DTL_ID")
	private Long workersMstDtlId;
		
	@Column(name="WORKERS_MST_ID")
	private Long workerMstId;
	
	@Column(name="num_of_units")
	private Long numOfUnits;
	
	@Column(name="active_flag")
	private Long activeFlag;
	
	@Column(name="total_amount")
	private Long totalAmount;
	
	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long CreatedBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;

	public Long getWorkersMstDtlId() {
		return workersMstDtlId;
	}

	public void setWorkersMstDtlId(Long workersMstDtlId) {
		this.workersMstDtlId = workersMstDtlId;
	}

	public Long getWorkerMstId() {
		return workerMstId;
	}

	public void setWorkerMstId(Long workerMstId) {
		this.workerMstId = workerMstId;
	}

	public Long getNumOfUnits() {
		return numOfUnits;
	}

	public void setNumOfUnits(Long numOfUnits) {
		this.numOfUnits = numOfUnits;
	}

	public Long getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Long activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
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
