package com.muravev.samokatimhandbook.service;

import com.muravev.samokatimhandbook.model.response.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrganizationService {
    Page<Organization> getAll(Pageable pageable);

    Organization create(Organization organization);
}
