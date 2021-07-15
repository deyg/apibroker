package com.hdi.insurance.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.hdi.insurance.api.exception.BusinessException;
import com.hdi.insurance.api.model.Broker;
import com.hdi.insurance.api.model.BrokerDetails;

import reactor.core.publisher.Mono;

@Service
public class BrokerService {
	
	@Autowired
	private WebClient webClientBrokerMaster;
	
	@Autowired 
	private WebClient webClienteBrokerDetails;
	
	public Broker findByDocument(String document){
		
		Mono<Broker>monoBrokerMaster = this.webClientBrokerMaster
				.method(HttpMethod.GET)
				.uri("/broker/{document}", document)
				.retrieve()
				.bodyToMono(Broker.class);	
				
		Broker broker = monoBrokerMaster.block();
		
		Mono<Broker>monoBrokerDetails = this.webClienteBrokerDetails
				.method(HttpMethod.GET)
				.uri("/brokerData/{code}", broker.getCode())
				.retrieve()
				.bodyToMono(Broker.class);
			
		Broker brokerDetails = monoBrokerDetails.block();
		
		broker.setActive(brokerDetails.getActive());
		broker.setCommissionRate(brokerDetails.getCommissionRate());
		
		if(!broker.getActive()) throw new BusinessException("Inativated broker.");
				
		return broker;
	}	
	
	
	public void updateStatus(String document, Boolean status) {
		
		Mono<Broker>monoBrokerMaster = this.webClientBrokerMaster
				.method(HttpMethod.GET)
				.uri("/broker/{document}", document)
				.retrieve()
				.bodyToMono(Broker.class);
			
		Broker brokerMaster = monoBrokerMaster.block();
		
		Mono<BrokerDetails>monoBrokerDetails = this.webClienteBrokerDetails
				.method(HttpMethod.GET)
				.uri("/brokerData/{code}", brokerMaster.getCode())
				.retrieve()
				.bodyToMono(BrokerDetails.class);
		
		BrokerDetails brokerDetails = monoBrokerDetails.block();
		
		brokerDetails.setActive(status);
				
	    webClienteBrokerDetails.put()
	        .uri("/brokerData/{code}", brokerDetails.getCode())
	        .body(Mono.just(brokerDetails), Broker.class)
	        .retrieve()
	        .bodyToMono(Broker.class).block();
	}
	

}
