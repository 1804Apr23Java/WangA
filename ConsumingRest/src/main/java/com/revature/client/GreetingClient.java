package com.revature.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.revature.beans.Greeting;

@Component("GreetingClient")
public class GreetingClient {

	@Autowired
	private RestTemplate restTemplate;

	private String resourceUrl;

	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	// Jackson is doing a lot of work behind the scenes!!
	// .exchange method allows finer-grained control over request being sent
	public List<Greeting> getGreetings() {
		ResponseEntity<List<Greeting>> response = this.restTemplate.exchange(this.resourceUrl + "/greeting/all",
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Greeting>>() {
				});
		return response.getBody();
	}

}
