 
package org.st.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.st.consumer.PaymentConsumer;

@RestController
public class InvoiceRestController {
	@Autowired
	private PaymentConsumer consumer;

	@GetMapping("/invoce")
	public String getMsg() {
		String msg=consumer.showMsg();
		return "From Consumer:"+msg;
	}
}



