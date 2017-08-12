package org.mayank.restapp.simple.security;

import org.mayank.restapp.simple.entities.UserEntity;

public class JwtUserFactory {

	private JwtUserFactory() {
    }

    public static JwtUser create(UserEntity userEntity) {
        return new JwtUser(
                userEntity.getUser_id(),
                userEntity.getUsername(),
                userEntity.getFirstname(),
                userEntity.getMiddlename(),
                userEntity.getLastname(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.isEnable()
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
