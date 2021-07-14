package com.hdi.insurance.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Broker {
	
	private String name;
	private String document;
	private String code;
	private String createDate;
	private Boolean active;
	private Float commissionRate;

}
