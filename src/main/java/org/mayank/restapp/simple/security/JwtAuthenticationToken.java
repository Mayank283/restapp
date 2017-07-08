package org.mayank.restapp.simple.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken{

	private static final long serialVersionUID = 1L;

	private String token;
	
	public JwtAuthenticationToken(String authToken) {
		super(null,null);
		this.token = authToken;
	}
	
	public String getToken(){
		return this.token;
	}
	
	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return null;
	}

}
