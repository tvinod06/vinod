package com.valueobject;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cmn_lookup_mst")
@Access(value=AccessType.FIELD)
public class CmnLookupMst {	
	@Id
	@Column(name="LOOKUP_ID")
	private Long lookupId;
	@Column(name="PARENT_LOOKUP_ID")
	private Long parentLookupId;
	@Column(name="LOOKUP_NAME")
	private String lookupName;
	@Column(name="LOOKUP_DESC")
	private String lookupDesc;
	@Column(name="created_dt")
	private Date createdDt;
	@Column(name="created_by")
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
