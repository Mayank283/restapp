package org.mayank.restapp.simple.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
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

	/**
	 * Method to generate the JwtToken once the user is authenticated from
	 * server
	 * 
	 * @param jwtUserRequest
	 *            sent from user login page consists of Username and Password
	 * @return Jwt token created by the application
	 */
	public String generateToken(JwtUserRequest jwtUserRequest) {

		// ~ Set Payload/Claims of JWT
		// ================================================================================================

		Claims claims = Jwts.claims().setSubject(jwtUserRequest.getUserName()).setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + 4 * 60 * 1000));

		// ~ Build Token
		// ================================================================================================

		return Jwts.builder().setHeaderParam(Header.TYPE, "JWS").setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, secret).compact();

	}

	/**
	 * Method to return username from JwtToken to create Userdetails Object
	 * 
	 * @param jwtToken
	 *            submitted by the secured resource
	 * @return username identity from the jwt token
	 */
	public String getUsernameFromToken(String jwtToken) {

		// String username;

		Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken);
		System.out.println(claims.getHeader().getType());
		System.out.println(claims.getSignature());
		System.out.println(claims.getBody().getSubject());
		System.out.println(claims.getBody().getIssuedAt());
		System.out.println(claims.getBody().getExpiration());
		return claims.getBody().getSubject();
	}
}
