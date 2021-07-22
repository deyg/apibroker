package com.hdi.insurance.api.connection;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {

	private static final String EXCHANGE_NAME = "hdi.amq.direct";
	private static final String BROKER_QUEUE_NAME = "hdi.queue.broker";
	
	private AmqpAdmin amqpAdmin;
	
	
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		super();
		this.amqpAdmin = amqpAdmin;
	}

	private Queue createQueue(String queueName) {
		return new Queue(queueName, true, false, false);
	}
	
	private DirectExchange createDirectExchange() {
		return new DirectExchange(EXCHANGE_NAME);
	}
	
	private Binding createBinding(Queue queue, DirectExchange exchange) {
		return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
	}
	
	@PostConstruct
	private void confiRabbitMQ() {
		
		Queue queueBroker = this.createQueue(BROKER_QUEUE_NAME);
		DirectExchange directExchange = this.createDirectExchange();
		Binding bindingBroker = this.createBinding(queueBroker, directExchange);
		
		this.amqpAdmin.declareQueue(queueBroker);		
		this.amqpAdmin.declareExchange(directExchange);		
		this.amqpAdmin.declareBinding(bindingBroker);
	}
	
	
}
