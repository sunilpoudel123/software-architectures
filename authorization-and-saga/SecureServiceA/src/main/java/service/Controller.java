package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	OAuth2RestTemplate restTemplate;


	@GetMapping("/product")
	public String getName() {
		return "Bag";
	}

	@GetMapping("/phone")
	public String getPhone() {
		return restTemplate.getForObject("http://localhost:8091/phone", String.class);
	}

	@GetMapping("/salary")
	public String getSalary() {
		return restTemplate.getForObject("http://localhost:8092/salary", String.class);
	}

}

