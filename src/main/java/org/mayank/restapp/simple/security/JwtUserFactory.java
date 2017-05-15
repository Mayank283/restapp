package org.mayank.restapp.simple.security;

import org.mayank.restapp.simple.model.User;

public class JwtUserFactory {

	private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                //user.getId(),
                user.getUsername()
                //user.getFirstname(),
                //user.getLastname(),
                //user.getEmail(),
                //user.getPassword()
                //mapToGrantedAuthorities(user.getAuthorities()),
                //user.getEnabled(),
                //user.getLastPasswordResetDate()
        );
    }

  /*  private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
                .collect(Collectors.toList());
    }*/
	
}
