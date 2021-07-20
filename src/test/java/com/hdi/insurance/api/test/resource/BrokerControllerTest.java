package com.hdi.insurance.api.test.resource;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;

import com.hdi.insurance.api.model.Broker;
import com.hdi.insurance.api.resource.BrokerController;
import com.hdi.insurance.api.service.BrokerService;

import io.restassured.http.ContentType;

@WebMvcTest
public class BrokerControllerTest {

	@Autowired
	private BrokerController brokerController;
	
	@MockBean
	private BrokerService brokerService;
	
	@MockBean
	private WebClient webClient;
	
		
	@BeforeEach
	public void setup() {
		standaloneSetup(this.brokerController);
	}
	
	
	@Test
	public void shouldReturnSuccess_WhenFindBroker() {

		when(this.brokerService.findByDocument("52225508003"))
			.thenReturn(new Broker("id", "Drummont", "52225508003", "00001", "2020-05-16", true, 0.9F));
			
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/insurance/v1/broker/{document}", "52225508003")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void shouldReturnNotFound_WhenFindBroker() {

		when(this.brokerService.findByDocument("555555555"))
			.thenReturn(null);
			
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/insurance/v1/broker/{document}", "555555555")
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
	
}
