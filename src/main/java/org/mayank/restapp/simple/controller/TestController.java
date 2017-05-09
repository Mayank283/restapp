package org.mayank.restapp.simple.controller;

import java.io.IOException;
import org.json.JSONException;
import org.mayank.restapp.simple.model.Test;
import org.mayank.restapp.simple.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@RequestMapping(method = RequestMethod.POST)
	public User testMethod(@RequestBody Test test) throws JSONException, JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
	    User usr = mapper.readValue(test.getRequest().toString(), User.class);      
		return usr;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String method1(){
		return "Done!";
	}
}