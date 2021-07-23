package com.hdi.analyser.api.consumer;

import com.hdi.analyser.api.model.Broker;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.hdi.analyser.api.constants.Constants;

@Component
public class BrokerConsumer {
	
	@RabbitListener(queues = Constants.RABBITMQ_BROKER_QUEUE_NAME)
	private void consumer(Broker broker) {
		System.out.println(broker.getName() + " " + broker.getDocument());
		System.out.println("]<->[");

	}

}
