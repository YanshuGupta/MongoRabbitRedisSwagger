package com.example.practice.rabbitmqmessage;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practice.dao.MessageRepository;
import com.example.practice.exception.CustomException;
import com.example.practice.util.WebUtils;

@Service
public class Receiver {

	@Autowired
	MessageRepository messageRepo;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static final String PRIMARY_QUEUE = "primaryWorkerQueue";

	public static final String PARKINGLOT_QUEUE = PRIMARY_QUEUE + ".parkingLot";

	private final Logger logger = LoggerFactory.getLogger(Receiver.class);
	@RabbitListener(queues = PRIMARY_QUEUE)
	public void primary(Message in) throws Exception {
		if (!processMessage(in.getBody())) {
			if (hasExceededRetryCount(in)) {
				putIntoParkingLot(in);
				return;
			}
			throw new CustomException("There was an error");
		}
	}

	private boolean processMessage(byte[] body) {
		String msg = new String(body);
		logger.info("Received msg: " + msg);
		if (msg != null && !msg.trim().isEmpty()) {
			com.example.practice.model.Message messageObj = new com.example.practice.model.Message(
					WebUtils.getRandomString(), msg);
			messageRepo.save(messageObj);
			return true;
		}
		return false;
	}

	private boolean hasExceededRetryCount(Message in) {
		List<Map<String, ?>> xDeathHeader = in.getMessageProperties().getXDeathHeader();
		if (xDeathHeader != null && xDeathHeader.size() >= 1) {
			Long count = (Long) xDeathHeader.get(0).get("count");
			return count >= 3;
		}

		return false;
	}

	private void putIntoParkingLot(Message failedMessage) {
		logger.error("Retries exeeded putting into parking lot");
		this.rabbitTemplate.send(PARKINGLOT_QUEUE, failedMessage);
	}
}