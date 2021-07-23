package com.hdi.analyser.api.model;

import com.hdi.analyser.api.emun.Classification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document
public class MetaBroker {

    @Id
    private String id;
    private String idBroker;
    private Classification classification;

}
