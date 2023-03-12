package com.muravev.samokatimhandbook.service;

import com.muravev.samokatimhandbook.model.request.OrganizationRequest;
import com.muravev.samokatimhandbook.model.response.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrganizationService {
    Page<Organization> getAll(Pageable pageable);

    Page<Organization> searchByKeyword(String keyword, Pageable pageable);

    Organization create(OrganizationRequest organization);

    Organization update(long id, OrganizationRequest organization);

    Organization approve(long organizationId);

    void delete(long orgId);

    Organization getOne(long id);
}
