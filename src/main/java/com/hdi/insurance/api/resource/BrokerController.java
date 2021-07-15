package com.hdi.insurance.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.hdi.insurance.api.model.Broker;
import com.hdi.insurance.api.service.BrokerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/insurance/v1/broker")
@Api(value = "API REST HDI  Broker")
@CrossOrigin(origins="*")
public class BrokerController {

	@Autowired
	private BrokerService brokerService;
	
	@GetMapping("/{document}")
	@ApiOperation(value="Retorna um Broker ativo")
	public ResponseEntity<Broker> getByDocument(@PathVariable String document){
		
		Broker broker = this.brokerService.findByDocument(document);
		
		if (broker == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(broker);
	}
	
	@PutMapping("/{document}/status")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Atualiza o status de um Broker")
	public void update(@PathVariable String document, @RequestBody Boolean status){		
		
		this.brokerService.updateStatus(document, status);		
		
	}

}
