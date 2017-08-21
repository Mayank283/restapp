package org.mayank.restapp.simple.security;

import java.util.List;
import java.util.stream.Collectors;

import org.mayank.restapp.simple.entities.Roles;
import org.mayank.restapp.simple.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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
        		user.isEnable(),
                mapToGrantedAuthorities((List<Roles>) user.getRoles())
              //user.getLastPasswordResetDate()
        );
    }

   private static List<GrantedAuthority> mapToGrantedAuthorities(List<Roles> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getRolename()))
                .collect(Collectors.toList());
    }
}
