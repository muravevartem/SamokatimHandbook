package com.muravev.samokatimhandbook.controller;

import com.muravev.samokatimhandbook.model.response.Organization;
import com.muravev.samokatimhandbook.model.response.PageableReactAdmin;
import com.muravev.samokatimhandbook.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/handbook/admin/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;


    @GetMapping
    public Page<Organization> getAll(PageableReactAdmin pageableReactAdmin) {
        return organizationService.getAll(pageableReactAdmin.toPageable());
    }

    @PostMapping
    public Organization create(@Valid @RequestBody Organization organization) {
        return organizationService.create(organization);
    }

}
