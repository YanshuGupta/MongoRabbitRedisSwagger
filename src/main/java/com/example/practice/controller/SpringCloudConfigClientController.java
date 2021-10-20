package com.example.practice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringCloudConfigClientController {

	/*
	 * Fetching the Property from git Repository mentioned in Config Server property files.
	 * By default main branch is used if not defined in Config server
	 * Active Profile is used from this application to fetch property value.
	 */
	@Value("${info.url}")
	String message;
	
	@GetMapping("/cloudConfigValue")
    public String home() {
        return message;
    }
}
