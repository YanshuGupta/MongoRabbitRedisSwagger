package com.example.practice.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientController {

	@Autowired
	Microservice1Client microservice1Client;
	
	@GetMapping("/microservice1check")
	public String index() {
		System.out.println("controle is here");
		return microservice1Client.index();
	}
}
