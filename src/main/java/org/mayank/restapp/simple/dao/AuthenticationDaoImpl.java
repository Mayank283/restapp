package org.mayank.restapp.simple.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {

	@Override
	public UserDetails getUserDetails(String username) {
		
		return null;
	}

	
}
