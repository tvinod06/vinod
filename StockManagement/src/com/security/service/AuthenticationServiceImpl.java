package com.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.dao.AuthenticationDao;
import com.security.vo.UserInfo;

@Service
public class AuthenticationServiceImpl implements UserDetailsService{

	@Autowired
	AuthenticationDao authenticationDao;

	static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {

		UserInfo userInfo = authenticationDao.getUserInfo(userName);
		
		if(userInfo == null){
			throw new UsernameNotFoundException("Username not found.");
		}
		
		List<String> roles = authenticationDao.getUserRoles(userName);
		List<GrantedAuthority> grantedList = new ArrayList<GrantedAuthority>();
		
		if(roles != null && !roles.isEmpty()){
			for(String role : roles){
				GrantedAuthority authority = new SimpleGrantedAuthority(role);
				grantedList.add(authority);
			}
		}
		String encodedPassword = passwordEncoder.encode(userInfo.getPassword());
		UserDetails userDtls = new User(userInfo.getUserName(),encodedPassword,grantedList);
		
		return userDtls;
	}

}
