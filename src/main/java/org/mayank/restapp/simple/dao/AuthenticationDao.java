package org.mayank.restapp.simple.dao;

import org.mayank.restapp.simple.model.User;

public interface AuthenticationDao {
	
	User getUserDetails(String username);	
}
