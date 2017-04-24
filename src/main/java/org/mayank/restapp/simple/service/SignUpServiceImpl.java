package org.mayank.restapp.simple.service;

import org.mayank.restapp.simple.model.User;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService{

	@Override
	public void signup(User user) {
		System.out.println(user.getUsername());	
	}
}
