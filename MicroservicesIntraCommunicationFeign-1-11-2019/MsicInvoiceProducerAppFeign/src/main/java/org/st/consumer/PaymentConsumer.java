package org.st.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("PAYMENT-PRODUCER")
public interface PaymentConsumer {
	@GetMapping("/payment")
	public String showMsg();
	
}



