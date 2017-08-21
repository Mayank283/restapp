package org.mayank.restapp.simple;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mayank.restapp.simple.entities.Roles;
import org.mayank.restapp.simple.entities.User;
import org.mayank.restapp.simple.repository.RolesRepository;
import org.mayank.restapp.simple.repository.UserDetailsRepository;
import org.mayank.restapp.simple.security.JwtUserRequest;
import org.mayank.restapp.simple.security.JwtUserResponse;
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
	RolesRepository rolesRepository;

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	LoginService loginService;

	JwtUserRequest jwtUserRequest = new JwtUserRequest();

	@Test
	public void givenShopAddToRepo() throws Exception {

		User user = userDetailsRepository.findByUsername("blehbleh@gmail.com");

		System.out.println(user.getEmail());
		
		 List<Roles> auth = (List<Roles>) user.getRoles();

		System.out.println(auth.get(0).getRolename());
		System.out.println(auth.get(1).getRolename());
		 
	}

	@Test
	public void givenShop() throws Exception {

		userDetailsService.loadUserByUsername("mayankagd@gmail.com");

	}

	@Test
	public void givenLogin() throws Exception {

		jwtUserRequest.setUserName("blehbleh@gmail.com");
		jwtUserRequest.setPassword("ddcf5e599ffa22db3ef522ade5c5c02b");

		JwtUserResponse jwtUserResponse= loginService.generateToken(jwtUserRequest);
		System.out.println(jwtUserResponse.getToken());

	}

	@Test
	public void saveUser() {
		List<Roles> roleList = new ArrayList<Roles>();
		List<Roles> roleList2 = new ArrayList<Roles>();
		Roles role1 = new Roles();
		Roles role2 = new Roles();
		role1.setRole_name("1");
		role2.setRole_name("2");
		roleList.add(role1);
		roleList.add(role2);
		roleList2.add(role1);
		User user = new User("blehbleh@gmail.com", "blehbleh@gmail.com", "blehbleh@10", "true", "John", "Kumar",
				"Carpenter");
		User user2 = new User("mayankagd@gmail.com", "mayankagd@gmail.com", "Zhangguolao@10", "true", "Mayank", "Kumar",
				"Agarwal");
		user.setRoles(roleList);
		user2.setRoles(roleList2);
		userDetailsRepository.save(user);
		userDetailsRepository.save(user2);
	}
}
