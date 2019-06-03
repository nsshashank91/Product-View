package com.wipro.productView;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication

public class ProductViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductViewApplication.class, args);
	}

}
