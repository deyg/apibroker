package com.hdi.insurance.api.rabbit.connection;

import javax.annotation.PostConstruct;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

import com.hdi.insurance.api.constants.Constants;

@Component
public class RabbitMQConnection {
	
	private AmqpAdmin amqpAdmin;
	
	
	public RabbitMQConnection(AmqpAdmin amqpAdmin) {
		super();
		this.amqpAdmin = amqpAdmin;
	}

	private Queue createQueue(String queueName) {
		return new Queue(queueName, true, false, false);
	}
	
	private DirectExchange createDirectExchange() {
		return new DirectExchange(Constants.RABBITMQ_EXCHANGE_NAME);
	}
	
	private Binding createBinding(Queue queue, DirectExchange exchange) {
		return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
	}
	
	@PostConstruct
	private void confiRabbitMQ() {
		
		Queue queueBroker = this.createQueue(Constants.RABBITMQ_BROKER_QUEUE_NAME);
		DirectExchange directExchange = this.createDirectExchange();
		Binding bindingBroker = this.createBinding(queueBroker, directExchange);
		
		this.amqpAdmin.declareQueue(queueBroker);		
		this.amqpAdmin.declareExchange(directExchange);		
		this.amqpAdmin.declareBinding(bindingBroker);
	}
	
	
}
