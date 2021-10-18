package com.example.practice.rabbitmqmessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
	private static final String PRIMARY_ROUTING_KEY = "primaryRoutingKey";
	public static final String PRIMARY_QUEUE = "primaryWorkerQueue";
	private static final String WAIT_QUEUE = PRIMARY_QUEUE + ".wait";

	
	@Autowired
    private RabbitTemplate template;

    public void send(String message) {
        this.template.convertAndSend("tutorial-exchange", PRIMARY_ROUTING_KEY, message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
