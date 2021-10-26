package com.example.practice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("MICROSERVICE1")
public interface Microservice1Client {

	@GetMapping("/micro1")
	String index();
}
