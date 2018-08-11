package com.security.dao;

import java.util.List;

import com.security.vo.UserInfo;

public interface AuthenticationDao {

	public UserInfo getUserInfo(String userName);
	
	public List<String> getUserRoles(String userName);
	
}
