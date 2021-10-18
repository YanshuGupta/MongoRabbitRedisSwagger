package com.example.practice.rabbitmqmessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitMQController {

	@Autowired
	Sender sender;
	
	@GetMapping("/send/{message}")
	public String sendMessageToQueue(@PathVariable String message) {
		sender.send(message);
		return "Message Send Successfully";
	}
}
