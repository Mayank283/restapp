package org.mayank.restapp.simple.security;

import org.mayank.restapp.simple.dao.UserDetailsRepository;
import org.mayank.restapp.simple.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity userEntity;

		userEntity = userDetailsRepository.findByUsername(username);

		if (userEntity == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			return JwtUserFactory.create(userEntity);
		}
	}
}