package com.muravev.samokatimhandbook.controller;

import com.muravev.samokatimhandbook.model.dictinary.OrganizationType;
import com.muravev.samokatimhandbook.service.dictionary.OrganizationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/handbook/dictionaries")
@RequiredArgsConstructor
public class DictionaryController {
    private final OrganizationTypeService organizationTypeService;


    @GetMapping("/organization-types")
    public Iterable<OrganizationType> getAllOrganizationTypes() {
        return organizationTypeService.getAll();
    }

}
