package com.st.rest;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableDiscoveryClient
public class AdminRestController {
	@GetMapping("/show")
	public String showData() {
		return "From Producer";		
	}
}