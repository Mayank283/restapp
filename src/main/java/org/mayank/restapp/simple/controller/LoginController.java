package org.mayank.restapp.simple.controller;

import org.mayank.restapp.simple.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@CrossOrigin
	@RequestMapping(value = "/login",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestBody User user){
		System.out.println(user.getPassword());
		return user;
	}
}
