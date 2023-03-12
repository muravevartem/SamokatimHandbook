package com.muravev.samokatimhandbook.service.impl;

import com.muravev.samokatimhandbook.entity.OrganizationEntity;
import com.muravev.samokatimhandbook.error.ApiException;
import com.muravev.samokatimhandbook.error.StatusCode;
import com.muravev.samokatimhandbook.mapper.OrganizationMapper;
import com.muravev.samokatimhandbook.model.request.OrganizationRequest;
import com.muravev.samokatimhandbook.model.response.Organization;
import com.muravev.samokatimhandbook.model.response.OrganizationStatus;
import com.muravev.samokatimhandbook.repository.OrganizationRepository;
import com.muravev.samokatimhandbook.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public Page<Organization> searchByKeyword(String keyword, Pageable pageable) {
        return repository.findByKeyword(keyword, pageable)
                .map(mapper::toDto);
    }

    @Override
    public Organization getOne(long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() ->
                        new ApiException(StatusCode.ORGANIZATION_NOT_FOUND));
    }

    @Override
    public Organization create(OrganizationRequest org) {
        if (repository.findByInn(org.getInn()).isPresent())
            throw new ApiException(StatusCode.ORGANIZATION_ALREADY_EXIST);
        var mappedOrg = mapper.toEntity(org);
        var savedOrg = repository.save(mappedOrg);
        log.info("New organization (inn: {})", savedOrg.getInn());
        return mapper.toDto(savedOrg);
    }

    @Override
    public Organization update(long id, OrganizationRequest org) {
        var orgFromDb = repository.findById(id)
                .filter(o -> Objects.equals(o.getInn(), org.getInn()))
                .orElseThrow(() -> new ApiException(StatusCode.ORGANIZATION_NOT_FOUND));
        var updatedOrg = mapper.mergeEntity(orgFromDb, org);
        resetStatus(updatedOrg);
        var savedOrg = repository.save(updatedOrg);
        log.info("Update organization (inn: {})", savedOrg.getInn());
        return mapper.toDto(savedOrg);
    }

    private void resetStatus(OrganizationEntity organization) {
        log.info("Reset organization status");
        organization.setStatus(OrganizationStatus.PENDING);
    }

    @Override
    public Organization approve(long orgId) {
        var orgFromDb = repository.findById(orgId)
                .orElseThrow(() -> new ApiException(StatusCode.ORGANIZATION_NOT_FOUND));

        if (orgFromDb.getStatus() != OrganizationStatus.PENDING)
            throw new ApiException(StatusCode.ORGANIZATION_IMPOSSIBLE_TO_VERIFY);

        orgFromDb.setStatus(OrganizationStatus.APPROVED);

        var savedOrg = repository.save(orgFromDb);
        log.info("Approved organization (inn:{})", orgFromDb.getInn());
        return mapper.toDto(savedOrg);
    }

    @Override
    public void delete(long orgId) {
        var orgFromDb = repository.findById(orgId)
                .orElseThrow(() -> new ApiException(StatusCode.ORGANIZATION_NOT_FOUND));
        repository.delete(orgFromDb);
        log.info("Delete organization (inn:{})", orgFromDb.getInn());
    }

}
