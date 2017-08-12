package org.mayank.restapp.simple.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long user_id;
	private String userName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String password;
	private Boolean enabled;
	private Collection<? extends GrantedAuthority> authorities;

	

	/**
	 * @param id
	 * @param userName
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param enabled
	 */
	public JwtUser(Long user_id, String userName, String firstName, String middleName, String lastName, String email,
			String password, Boolean enabled) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
	}

	/**
	 * @param userName
	 * @param enable
	 */
	public JwtUser(String userName,Boolean enable) {
		super();
		this.userName = userName;
		this.enabled = enable;
	}

	public Long getId() {
		return this.user_id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	@Override
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public boolean isEnabled() {
		return this.enabled;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
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
}