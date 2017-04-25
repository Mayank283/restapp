
package org.mayank.restapp.simple.controller;


import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void login(@RequestHeader("Authorization") String auth) {
		auth = auth.replaceAll("Basic", "");
		byte[] decoded = Base64.decode(auth.getBytes());
		String[] array = StringUtils.delimitedListToStringArray(Utf8.decode(decoded), ":"); //Or StringUtils.newStringUtf8(decoded).split(":");
		String userName = array[0];
		String password = array[1];
		System.out.println(userName);
		System.out.println(password);
	}
}
