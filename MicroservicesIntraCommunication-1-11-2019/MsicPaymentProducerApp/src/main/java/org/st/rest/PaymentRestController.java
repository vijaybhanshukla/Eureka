package org.st.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentRestController {
	@Value("${server.port}")
	private String port;
	@GetMapping("/payment")
	public String showMsg() {
		return "FROM PAYMENT PRODUCER:"+port;
	}
	
}


