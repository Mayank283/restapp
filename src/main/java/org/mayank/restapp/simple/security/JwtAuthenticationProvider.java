package org.mayank.restapp.simple.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	JwtUtility jwtUtility;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication; 
		
		String token = jwtAuthenticationToken.getToken();
		System.out.println(token);
		String userName = jwtUtility.getUsernameFromToken(token);
		System.out.println(userName);
		
		/*if (userName == null) {
			throw new JwtTokenMalformedException("JWT token is not valid");
		}*/

		return new JwtUser(userName);		
	}
}
