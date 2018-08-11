package com.security.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.security.vo.UserInfo;
import com.session.HibernateSession;

@Transactional
public class AuthenticationDaoImpl extends HibernateSession implements AuthenticationDao{

	@Override
	public UserInfo getUserInfo(String userName) {
		UserInfo userInfo = null;
		List<Object[]> userList = getSession().createQuery("select userName, password, userId from UserInfo where userName = '"+userName+"' and activeFlag = 1").getResultList();	
		if(userList != null && !userList.isEmpty()){
			userInfo = new UserInfo();
			userInfo.setUserName(userList.get(0)[0].toString());
			userInfo.setPassword(userList.get(0)[1].toString());
			userInfo.setUserId(Long.valueOf(userList.get(0)[2].toString()));
		}
		return userInfo;
	}

	@Override
	public List<String> getUserRoles(String userName) {
		List<String> userList = getSession().createQuery("select distinct roleName from UserRoleInfo where userName = '"+userName+"' and activeFlag = 1").getResultList();	
		return userList;
	}

}
