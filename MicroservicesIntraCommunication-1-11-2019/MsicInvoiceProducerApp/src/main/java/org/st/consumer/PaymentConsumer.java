package org.st.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentConsumer {
	@Autowired
	private LoadBalancerClient client;
	
	public String showMsg() {
		ServiceInstance si=client.choose("PAYMENT-PRODUCER");
		String URL=si.getUri()+"/payment";
		RestTemplate rt=new RestTemplate();
		ResponseEntity<String> resp=rt.getForEntity(URL, String.class);
		return resp.getBody();
	}
	
	
	
	
}


