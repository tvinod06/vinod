package com.dto;

import java.util.Date;
import java.util.List;

public class WorkersFormBean {
	
	private Long workersMstId;
	private Long ratePerUnit;
	private Long totalAmount;
	private Date createdDate;
	private Long CreatedBy;
	private Date updatedDate;
	private Long updatedBy;
	private List<WorkersFormBean> workersList;
	private String remarks;
	private Long numOfWorkers;
	private Long activeFlag;
	private Long numOfUnits;
	
	
	public Long getNumOfUnits() {
		return numOfUnits;
	}
	public void setNumOfUnits(Long numOfUnits) {
		this.numOfUnits = numOfUnits;
	}
	public Long getWorkersMstId() {
		return workersMstId;
	}
	public void setWorkersMstId(Long workersMstId) {
		this.workersMstId = workersMstId;
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
	public List<WorkersFormBean> getWorkersList() {
		return workersList;
	}
	public void setWorkersList(List<WorkersFormBean> workersList) {
		this.workersList = workersList;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getNumOfWorkers() {
		return numOfWorkers;
	}
	public void setNumOfWorkers(Long numOfWorkers) {
		this.numOfWorkers = numOfWorkers;
	}
	public Long getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Long activeFlag) {
		this.activeFlag = activeFlag;
	}
	
	
	
	
}
