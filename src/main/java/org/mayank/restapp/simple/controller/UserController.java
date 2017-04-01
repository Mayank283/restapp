package org.mayank.restapp.simple.controller;

import org.mayank.restapp.simple.model.User;
import org.mayank.restapp.simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	UserService userService;

	@CrossOrigin
	@RequestMapping(value = "/signup", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void signUp(@RequestBody User user) {
		userService.signup(user);
	}
}
