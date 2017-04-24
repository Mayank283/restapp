package org.mayank.restapp.simple.dao;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationDao {
	
	UserDetails getUserDetails(String username);	
}
