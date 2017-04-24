package org.mayank.restapp.simple.security;

import org.mayank.restapp.simple.dao.AuthenticationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService{

	@Autowired
	AuthenticationDao authenticationDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDetails user;
		user = authenticationDao.getUserDetails(username);
		return user;
	}
}