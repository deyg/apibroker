package com.hdi.analyser.api.resource;

import com.hdi.analyser.api.model.MetaBroker;
import com.hdi.analyser.api.service.MetaBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/analyser")
public class MetaBrokerController {

    @Autowired
    private MetaBrokerService metaBrokerService;

    @GetMapping()
    public ResponseEntity<List<MetaBroker>> findAll(){
        return ResponseEntity.ok(this.metaBrokerService.findAll());
    }
}
