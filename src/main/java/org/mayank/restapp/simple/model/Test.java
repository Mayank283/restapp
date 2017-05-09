package org.mayank.restapp.simple.model;

import org.json.JSONObject;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Test {

	@JsonProperty
	String requestType;
	
	@JsonProperty
	JSONObject request;
	
	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	public JSONObject getRequest() {
		return request;
	}

	public void setRequest(JSONObject request) {
		this.request = request;
	}
}