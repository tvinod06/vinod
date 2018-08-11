package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "workers_mst")
@Access(value=AccessType.FIELD)
public class Workers {

	@Id
	@Column(name="WORKERS_MST_ID")
	private Long workerMstId;
	
	@Column(name="num_of_workers")
	private Long numberOfWorkers;
	
	@Column(name="rate_per_unit")
	private Long ratePerUnit;
	
	@Column(name="active_flag")
	private Long activeFlag;
	
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

	public Long getWorkerMstId() {
		return workerMstId;
	}

	public void setWorkerMstId(Long workerMstId) {
		this.workerMstId = workerMstId;
	}

	public Long getNumberOfWorkers() {
		return numberOfWorkers;
	}

	public void setNumberOfWorkers(Long numberOfWorkers) {
		this.numberOfWorkers = numberOfWorkers;
	}

	public Long getRatePerUnit() {
		return ratePerUnit;
	}

	public void setRatePerUnit(Long ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
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
