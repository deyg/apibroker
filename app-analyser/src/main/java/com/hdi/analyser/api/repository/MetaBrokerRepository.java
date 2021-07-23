package com.hdi.analyser.api.repository;

import com.hdi.analyser.api.model.MetaBroker;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetaBrokerRepository extends MongoRepository<MetaBroker, String> {
}
