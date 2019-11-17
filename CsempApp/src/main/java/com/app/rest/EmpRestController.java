package com.app.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class EmpRestController {

	@Value("${my.code}")
	private String code;
	@GetMapping("/show")
	public String showData() {
		return "FROM CS:"+code;		
	}
	
}
