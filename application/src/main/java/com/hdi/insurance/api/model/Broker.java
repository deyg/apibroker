package com.hdi.insurance.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document
public class Broker {
	
	@Id
	private String id;
	private String name;
	private String document;
	private String code;
	private String createDate;
	private Boolean active;
	private Float commissionRate;

}
