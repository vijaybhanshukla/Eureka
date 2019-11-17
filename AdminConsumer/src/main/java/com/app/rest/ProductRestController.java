
package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ProductRestController {
	@Autowired
	private DiscoveryClient client;
	@GetMapping("/data")
	public String getproducerData() {	
		
//		use serviceID and fetch List<SI>
		
		List<ServiceInstance> list=client.getInstances("ADMIN-PRODUCER");
//		user index 0 and get service instance
		ServiceInstance si=list.get(0); 
		
//		get URI from SI and Add path 
		String Url=si.getUri()+"/show";
		
//		use rest Tamplet object 
		RestTemplate rt= new RestTemplate();
		
//		make request call and get respose
		ResponseEntity<String> resp=rt.getForEntity(Url , String.class);

//		read response and status 
		String res=resp.getStatusCode()+"-"+resp.getStatusCode().name();
				
		return "consumergot:"+res;		
	}

}
