package com.hdi.insurance.api.rabbit.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendMessage(String queueName, Object message) {
		rabbitTemplate.convertAndSend(queueName, message);		
	}
}
