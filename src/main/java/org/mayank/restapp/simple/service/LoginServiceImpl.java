package org.mayank.restapp.simple.service;

import org.mayank.restapp.simple.security.JwtUserRequest;
import org.mayank.restapp.simple.security.JwtUserResponse;
import org.mayank.restapp.simple.security.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	JwtUtility jwtUtility; 	
	
	@Override
	public JwtUserResponse generateToken(JwtUserRequest jwtUserRequest) {
		
		return 	new JwtUserResponse(jwtUtility.generateToken(jwtUserRequest));
		
	}

	
}
