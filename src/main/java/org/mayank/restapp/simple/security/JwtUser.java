package org.mayank.restapp.simple.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String userName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private Boolean enabled;
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getMiddleName() {
		return this.middleName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public Long getId() {
		return this.id;
	}
}