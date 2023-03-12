package com.muravev.samokatimhandbook.intergration.fns.service.impl;

import com.muravev.samokatimhandbook.intergration.fns.model.DaDataOrganization;
import com.muravev.samokatimhandbook.intergration.fns.model.DaDataRequest;
import com.muravev.samokatimhandbook.intergration.fns.model.InnDaDataResponse;
import com.muravev.samokatimhandbook.intergration.fns.service.FnsOrganizationSearcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FnsOrganizationSearcherImpl implements FnsOrganizationSearcher {
    private final static String SUGGEST_ENDPOINT = "/suggestions/api/4_1/rs/suggest/party";

    @Qualifier("fnsClient")
    private final RestTemplate fnsClient;


    @Override
    public List<DaDataOrganization> searchByInn(String inn) {
        var responseEntity = fnsClient.postForEntity(
                SUGGEST_ENDPOINT,
                new DaDataRequest(inn),
                InnDaDataResponse.class
        );
        InnDaDataResponse body = responseEntity.getBody();
        if (body == null)
            return new ArrayList<>();

        return body.getSuggestions();
    }
}
