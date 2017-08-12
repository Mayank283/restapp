package org.mayank.restapp.simple.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	// ~ Instance fields
	// ================================================================================================

	@Autowired
	JwtUtility jwtUtility;

	// ~ Methods
	// ========================================================================================================

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.authentication.dao.
	 * AbstractUserDetailsAuthenticationProvider#additionalAuthenticationChecks(
	 * org.springframework.security.core.userdetails.UserDetails,
	 * org.springframework.security.authentication.
	 * UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.authentication.dao.
	 * AbstractUserDetailsAuthenticationProvider#retrieveUser(java.lang.String,
	 * org.springframework.security.authentication.
	 * UsernamePasswordAuthenticationToken)
	 */
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {

		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;

		String jwtToken = jwtAuthenticationToken.getToken();

		return jwtUtility.getuserDetails(jwtToken);
	}
}
