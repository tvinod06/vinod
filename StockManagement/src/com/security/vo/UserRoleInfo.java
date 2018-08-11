package com.security.vo;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sms_user_role_mst")
@Access(value=AccessType.FIELD)
public class UserRoleInfo {

	@Id
	@Column(name="user_role_id")
	private String userRoleId;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_id")
	private Long roleId;
	
	@Column(name="active_flag")
	private Long activeFlag;

	@Column(name="created_dt")
	private Date createdDate;
	
	@Column(name="created_by")
	private Long createdBy;
	
	@Column(name="updated_dt")
	private Date updatedDate;
	
	@Column(name="updated_by")
	private Long updatedBy;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(Long activeFlag) {
		this.activeFlag = activeFlag;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
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
