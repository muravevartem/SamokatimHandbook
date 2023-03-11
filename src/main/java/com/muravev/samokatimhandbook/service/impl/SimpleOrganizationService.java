package com.muravev.samokatimhandbook.service.impl;

import com.muravev.samokatimhandbook.mapper.OrganizationMapper;
import com.muravev.samokatimhandbook.model.response.Organization;
import com.muravev.samokatimhandbook.repository.OrganizationRepository;
import com.muravev.samokatimhandbook.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SimpleOrganizationService implements OrganizationService {
    private final OrganizationRepository repository;
    private final OrganizationMapper mapper;

    @Override
    public Page<Organization> getAll(Pageable pageable) {
        var organizations = repository.findAll(pageable);
        return organizations.map(mapper::toDto);
    }

    @Override
    public Organization create(Organization organization) {
        var organizationEntity = mapper.toEntity(organization);
        var savedOrganization = repository.save(organizationEntity);
        return mapper.toDto(savedOrganization);
    }
}
