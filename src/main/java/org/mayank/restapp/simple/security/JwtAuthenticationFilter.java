package org.mayank.restapp.simple.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import io.jsonwebtoken.JwtException;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	public JwtAuthenticationFilter(String defaultFilterProcessesUrl) {
		super(defaultFilterProcessesUrl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * AbstractAuthenticationProcessingFilter#attemptAuthentication(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		System.out.println(request.getMethod());
		if (request.getMethod().equals(RequestMethod.GET.toString())) {

			response.setHeader("Access-Control-Allow-Origin", "http://ec2-13-126-239-177.ap-south-1.compute.amazonaws.com");
			response.setHeader("Access-Control-Allow-Headers", "authorization");
			response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE");
			response.setHeader("Access-Control-Max-Age", "1800");
			
			String header = request.getHeader("Authorization");
			if (header.isEmpty() || header == null) {
				throw new JwtException("No JWT token found in request headers");
			}

			JwtAuthenticationToken authRequest = new JwtAuthenticationToken(header);
			return getAuthenticationManager().authenticate(authRequest);
		}
		else{
			response.setHeader("Access-Control-Allow-Origin", "http://ec2-13-126-239-177.ap-south-1.compute.amazonaws.com");
			response.setHeader("Access-Control-Allow-Headers", "authorization");
			response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,DELETE");
			response.setHeader("Access-Control-Max-Age", "1800");
			return null;	
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.web.authentication.
	 * AbstractAuthenticationProcessingFilter#successfulAuthentication(javax.
	 * servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,
	 * javax.servlet.FilterChain,
	 * org.springframework.security.core.Authentication)
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		if (logger.isDebugEnabled()) {
			logger.debug("Authentication success. Updating SecurityContextHolder to contain: " + authResult);
		}

		SecurityContextHolder.getContext().setAuthentication(authResult);

		// As this authentication is in HTTP header, after success we need to
		// continue the request normally
		// and return the response as if the resource was not secured at all
		chain.doFilter(request, response);
	}
}