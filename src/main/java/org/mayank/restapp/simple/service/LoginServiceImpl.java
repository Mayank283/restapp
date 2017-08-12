package org.mayank.restapp.simple.service;

import org.mayank.restapp.simple.exception.PasswordException;
import org.mayank.restapp.simple.security.JwtUserRequest;
import org.mayank.restapp.simple.security.JwtUserResponse;
import org.mayank.restapp.simple.security.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	JwtUtility jwtUtility;

	@Autowired
	UserDetailsService userDetailsService;

	@Override
	public JwtUserResponse generateToken(JwtUserRequest jwtUserRequest) throws PasswordException {

		UserDetails user = userDetailsService.loadUserByUsername(jwtUserRequest.getUserName());

		if (!jwtUserRequest.getPassword().equals(user.getPassword())) {
			throw new PasswordException("Invalid Password!");
		}

		else {
			return new JwtUserResponse(jwtUtility.generateToken(user));
		}
	}
}
