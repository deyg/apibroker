package com.hdi.insurance.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hdi.insurance.api.model.Broker;

public interface BrokerRepository extends MongoRepository<Broker, String> {

}
