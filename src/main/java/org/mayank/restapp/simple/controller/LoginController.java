
package org.mayank.restapp.simple.controller;


import org.mayank.restapp.simple.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@Autowired
	User user;
	
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User login(@RequestBody String userName,@RequestHeader("Authorization") String auth/*@RequestHeader("From") String username*/) {
		
		user.setUsername(userName);
		user.setPassword(auth);
		return user;
		/*auth = auth.replaceAll("Basic", "");
		byte[] decoded = Base64.decode(auth.getBytes());
		String[] array = StringUtils.delimitedListToStringArray(Utf8.decode(decoded), ":"); //Or StringUtils.newStringUtf8(decoded).split(":");
		String userName = array[0];
		String password = array[1];
		System.out.println(userName);
		System.out.println(password);*/
	}
}
