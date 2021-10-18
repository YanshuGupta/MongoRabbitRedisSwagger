package com.example.practice.rabbitmqmessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	private static final String PRIMARY_ROUTING_KEY = "primaryRoutingKey";
	public static final String PRIMARY_QUEUE = "primaryWorkerQueue";
	private final Logger logger = LoggerFactory.getLogger(Sender.class);
	
	@Autowired
	private RabbitTemplate template;

	public void send(String message) {
		this.template.convertAndSend("tutorial-exchange", PRIMARY_ROUTING_KEY, message);
		logger.info(" [x] Sent '" + message + "'");
	}
}
