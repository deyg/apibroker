package com.hdi.insurance.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class BrokerDetails {
	
	private String code;	
	private Boolean active;
	private Float commissionRate;

}
