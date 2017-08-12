package org.mayank.restapp.simple.service;

import org.mayank.restapp.simple.exception.PasswordException;
import org.mayank.restapp.simple.security.JwtUserRequest;
import org.mayank.restapp.simple.security.JwtUserResponse;

public interface LoginService {

	public JwtUserResponse generateToken(JwtUserRequest jwtUserRequest) throws PasswordException;
	
}
