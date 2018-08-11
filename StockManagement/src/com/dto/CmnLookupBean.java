package com.dto;

import java.util.Date;

public class CmnLookupBean {
	
	private Long lookupId;
	private Long parentLookupId;
	private String lookupName;
	private String lookupDesc;
	private Date createdDt;
	private Long createdBy;
	public Long getLookupId() {
		return lookupId;
	}
	public void setLookupId(Long lookupId) {
		this.lookupId = lookupId;
	}
	public Long getParentLookupId() {
		return parentLookupId;
	}
	public void setParentLookupId(Long parentLookupId) {
		this.parentLookupId = parentLookupId;
	}
	public String getLookupName() {
		return lookupName;
	}
	public void setLookupName(String lookupName) {
		this.lookupName = lookupName;
	}
	public String getLookupDesc() {
		return lookupDesc;
	}
	public void setLookupDesc(String lookupDesc) {
		this.lookupDesc = lookupDesc;
	}
	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
