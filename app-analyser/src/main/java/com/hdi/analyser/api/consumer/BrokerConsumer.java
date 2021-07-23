package com.hdi.analyser.api.consumer;

import com.hdi.analyser.api.model.Broker;
import com.hdi.analyser.api.service.MetaBrokerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hdi.analyser.api.constants.Constants;

@Component
public class BrokerConsumer {

	@Autowired
	MetaBrokerService metaBrokerService;

	@RabbitListener(queues = Constants.RABBITMQ_BROKER_QUEUE_NAME)
	private void consumer(Broker broker) {
		metaBrokerService.create(broker);
	}

}
