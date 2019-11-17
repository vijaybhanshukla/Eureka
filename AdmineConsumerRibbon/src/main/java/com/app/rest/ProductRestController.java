package com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductRestController {
	@Autowired 
	private LoadBalancerClient client;
	@GetMapping("/data")
	public String getProducerData() {
//		 use service ID and fetch one si
		ServiceInstance si=client.choose("ADMIN-PRODUCER");
		
//		 get uri from si and add path
		String url=si.getUri()+"/show";
		
//		use RestTemplate object
		RestTemplate rt=new RestTemplate();
		ResponseEntity<String> resp=rt.getForEntity(url, String.class);
		
//		read response and status
		String res=resp.getBody()+"-"+resp.getStatusCode();
		return "consumergot:"+res;		
	}

}
