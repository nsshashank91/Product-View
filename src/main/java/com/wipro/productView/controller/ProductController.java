package com.wipro.productView.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.wipro.productView.domain.Product;
import com.wipro.productView.service.ProductService;
import com.wipro.productView.util.ProductValue;

@RestController
public class ProductController {
	
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@Autowired
	private ProductService service;
	
	@Autowired
	private ProductValue productValue;
	
	@Autowired
	private KafkaTemplate<String, Product> kafkaTemplate;
	
	private String TOPIC_NAME = "product";
	
	

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getAllProducts() {
		  HttpHeaders headers = new HttpHeaders();
		  RestTemplate restTemplate = restTemplateBuilder.build();
			
//			using Eureka-Server
			InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("eureka-service-app", false);
			String baseUrl = instanceInfo.getHomePageUrl();
			baseUrl = baseUrl + "product/api/getAllProducts";
			
			
		List<Product> productList=service.getAllProducts(baseUrl);
		if (productList == null) {
			   return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
			  }
			  headers.add("Number Of Records Found", String.valueOf(productList.size()));
			  return new ResponseEntity<List<Product>>(productList, headers, HttpStatus.OK);
			  
	}
	
	
	@RequestMapping(value = "/getProduct/{id}", method = RequestMethod.GET)
	 public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) {
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("eureka-service-app", false);
		String baseUrl = instanceInfo.getHomePageUrl();
		baseUrl = baseUrl + "product/api/getProduct";
		Product product = service.getProduct(baseUrl,id);
	  if (product == null) {
	   return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	  }
	  return new ResponseEntity<Product>(product, HttpStatus.OK);
	 }
	
	@RequestMapping( value = "/create")
	 public ResponseEntity<String> createProduct() {
		//InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("eureka-service-app", false);
		//String baseUrl = instanceInfo.getHomePageUrl();
		//baseUrl = baseUrl + "product/api/create";
		
		try {
			
			for(int i=0;i<50;i++) {
				
				LocalDateTime time = LocalDateTime.now();
				Product product = productValue.getProduct();
				product.setTime(time.toString());
				kafkaTemplate.send(TOPIC_NAME,product);
			}
			
			
			
		}
	 catch(Exception e) {
	   return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	  }
	  return new ResponseEntity<String>("Product Sent to Kafka Successfully", HttpStatus.OK);
	 }
	
	
}
