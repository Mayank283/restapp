package org.mayank.restapp.simple.service;

import org.mayank.restapp.simple.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService{

	@Override
	public void signup(User user) {
		System.out.println(user.getName());	
	}
}
