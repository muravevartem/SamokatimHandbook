package com.muravev.samokatimhandbook.intergration.fns.service.impl;

import com.muravev.samokatimhandbook.intergration.fns.mapper.DaDataOrganizationMapper;
import com.muravev.samokatimhandbook.intergration.fns.service.FnsOrganizationService;
import com.muravev.samokatimhandbook.intergration.fns.service.FnsOrganizationSearcher;
import com.muravev.samokatimhandbook.model.response.Organization;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class FnsOrganizationServiceImpl implements FnsOrganizationService {
    private final FnsOrganizationSearcher searcher;
    private final DaDataOrganizationMapper mapper;


    @Override
    public Organization searchFirstByInn(String inn) {
        var organizations = searcher.searchByInn(inn);
        return organizations.stream()
                .filter(org -> Objects.equals(inn, org.getData().getInn()))
                .map(mapper::toOrganization)
                .findFirst()
                .orElseGet(() -> getDummyOrganization(inn));
    }

    private Organization getDummyOrganization(String inn) {
        return new Organization()
                .setInn(inn);
    }
}
