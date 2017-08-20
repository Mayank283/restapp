package org.mayank.restapp.simple.security;

import org.mayank.restapp.simple.entities.User;

public class JwtUserFactory {

	private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
        		user.getUser_id(),
        		user.getUsername(),
        		user.getFirstname(),
        		user.getMiddlename(),
        		user.getLastname(),
        		user.getEmail(),
        		user.getPassword(),
        		user.isEnable()
              //mapToGrantedAuthorities(user.getAuthorities()),
              //user.getLastPasswordResetDate()
        );
    }

  /*  private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }*/
	
}
