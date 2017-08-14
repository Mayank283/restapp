package org.mayank.restapp.simple;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mayank.restapp.simple.dao.UserDetailsRepository;
import org.mayank.restapp.simple.entities.Authority;
import org.mayank.restapp.simple.entities.UserEntity;
import org.mayank.restapp.simple.security.JwtUserRequest;
import org.mayank.restapp.simple.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDetailsRepositoryTest {

	@Autowired
	UserDetailsRepository userDetailsRepository;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	LoginService loginService;

	JwtUserRequest jwtUserRequest = new JwtUserRequest();

	@Test
	public void givenShopAddToRepo() throws Exception {

		UserEntity userEntity = userDetailsRepository.findByUsername("mayankagd@gmail.com");

		System.out.println(userEntity.getEmail());
		List<Authority> auth = (List<Authority>)userEntity.getAuthorities();
		System.out.println(auth.get(0).getRole_name());
		System.out.println(auth.get(1).getRole_name());
	}

	@Test
	public void givenShop() throws Exception {

		userDetailsService.loadUserByUsername("mayankagd@gmail.com");

	}

	@Test
	public void givenLogin() throws Exception {

		jwtUserRequest.setUserName("mayankagd@gmail.com");
		jwtUserRequest.setPassword("Triptolemus@10");

		loginService.generateToken(jwtUserRequest);

	}
}
