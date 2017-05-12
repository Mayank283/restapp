package org.mayank.restapp.simple.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtility {

	@Value("${jwt.secret}")
    private String secret;
	
	public String generateToken(JwtUserRequest u) {
        Claims claims = Jwts.claims().setSubject(u.getUserName());
        claims.put("password", u.getPassword() + "");
        /*claims.put("userId", u.getId() + "");
        claims.put("role", u.getRole());
*/
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret) //Signature Algorithm
                .compact();
    }
}
