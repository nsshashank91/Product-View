package com.wipro.productView.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wipro.productView.domain.HelloWorldBean;

@RestController
public class HomeController {
	
	@GetMapping(path = "/home")
	public HelloWorldBean getHelloWorldMessage() {
		return new HelloWorldBean("This is Welcome Page");
	}
}
