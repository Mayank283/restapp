package org.mayank.restapp.simple.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
	private static final String ROLES = "roles";

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
		publicClaims.put(ROLES, generateRolesForUser(userDetails));

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

		String roles = claims.getBody().get(ROLES).toString();

		System.out.println(roles);

		Collection<? extends GrantedAuthority> authorities = Arrays.asList(roles.split(",")).stream()
				.map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
		return new JwtUser(username, enable, authorities);

	}

	public String generateRolesForUser(UserDetails userDetails) {

		List<GrantedAuthority> auth = (List<GrantedAuthority>) userDetails.getAuthorities();

		return auth.stream().map(mapper -> mapper.getAuthority()).collect(Collectors.joining(","));
	}
}