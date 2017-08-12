package org.mayank.restapp.simple.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtility {

	@Value("${jwt.secret}")
	private String secret;

	Map<String, Object> publicClaims;

	private static final String ENABLE = "enable";
	
	
	

	/**
	 * Method to generate the JwtToken once the user is authenticated from
	 * server
	 * 
	 * @param jwtUserRequest
	 *            sent from user login page consists of Username and Password
	 * @return Jwt token created by the application
	 */
	public String generateToken(UserDetails userDetails) {

		// ~ Set Payload/Claims of JWT
		// ================================================================================================

		publicClaims = new HashMap<String, Object>();
		publicClaims.put(ENABLE, userDetails.isEnabled());

		Claims claims = Jwts.claims(publicClaims).setSubject(userDetails.getUsername()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 4 * 60 * 1000));

		// ~ Build Token
		// ================================================================================================

		return Jwts.builder().setHeaderParam(Header.TYPE, "JWS").setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret).compact();

	}
	
	
	

	/**
	 * @param jwtToken
	 * @return
	 */
	public UserDetails getuserDetails(String jwtToken) {

		Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken);
		String username = claims.getBody().getSubject();
		Boolean enable = (Boolean) claims.getBody().get(ENABLE);
		return new JwtUser(username, enable);

	}
}
