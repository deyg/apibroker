package com.hdi.analyser.api.service;

import com.hdi.analyser.api.emun.Classification;
import com.hdi.analyser.api.model.Broker;
import com.hdi.analyser.api.model.MetaBroker;
import com.hdi.analyser.api.repository.MetaBrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaBrokerService {

    @Autowired
    MetaBrokerRepository metaBrokerRepository;

    public List<MetaBroker> findAll(){
        return metaBrokerRepository.findAll();
    }

    public MetaBroker create(Broker broker){
        MetaBroker metaBroker;
        metaBroker = calculatedBrokerClassification(broker);
        metaBroker.setIdBroker(broker.getId());
        return metaBrokerRepository.save(metaBroker);
    }

    private MetaBroker calculatedBrokerClassification(Broker broker){
        MetaBroker metaBroker = new MetaBroker();
        if (broker.getCommissionRate() <= 0.2F) {metaBroker.setClassification(Classification.WHITE);}
        else if (broker.getCommissionRate() <= 0.4F) {metaBroker.setClassification(Classification.BLUE);}
        else if (broker.getCommissionRate() <= 0.6F) {metaBroker.setClassification(Classification.YELLOW);}
        else if (broker.getCommissionRate() <= 0.8F) {metaBroker.setClassification(Classification.SILVER);}
        else if (broker.getCommissionRate() <= 1.0F) {metaBroker.setClassification(Classification.GOLD);}
        return metaBroker;
    }
}
