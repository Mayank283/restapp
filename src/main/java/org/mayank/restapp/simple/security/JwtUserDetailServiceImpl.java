package org.mayank.restapp.simple.security;

import org.mayank.restapp.simple.dao.AuthenticationDao;
import org.mayank.restapp.simple.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	AuthenticationDao authenticationDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user;
		user = authenticationDao.getUserDetails(username);//why ??
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			 return JwtUserFactory.create(user);
		}
	}
}