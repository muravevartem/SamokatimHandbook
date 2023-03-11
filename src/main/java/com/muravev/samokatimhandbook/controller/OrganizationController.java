package com.muravev.samokatimhandbook.controller;

import com.muravev.samokatimhandbook.model.request.OrganizationRequest;
import com.muravev.samokatimhandbook.model.response.Organization;
import com.muravev.samokatimhandbook.service.OrganizationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/organizations")
@RequiredArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;


    @GetMapping
    public Page<Organization> getAll(@PageableDefault Pageable pageable) {
        return organizationService.getAll(pageable);
    }

    @PostMapping
    public Organization create(@Valid @RequestBody OrganizationRequest organization) {
        return organizationService.create(organization);
    }

    @PutMapping("/{id}")
    public Organization update(@PathVariable Long id, @Valid @RequestBody OrganizationRequest organization) {
        return organizationService.update(id, organization);
    }

    @PutMapping("/{id}/approve")
    public Organization approve(@PathVariable Long id) {
        return organizationService.approve(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        organizationService.delete(id);
    }

}
