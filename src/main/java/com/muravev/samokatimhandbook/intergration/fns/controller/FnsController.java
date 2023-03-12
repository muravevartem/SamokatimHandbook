package com.muravev.samokatimhandbook.intergration.fns.controller;

import com.muravev.samokatimhandbook.intergration.fns.service.FnsOrganizationService;
import com.muravev.samokatimhandbook.model.response.Organization;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fns/organizations")
@RequiredArgsConstructor
public class FnsController {
    private final FnsOrganizationService organizationService;


    @GetMapping(params = "inn")
    public Organization searchByInn(@RequestParam String inn) {
        return organizationService.searchFirstByInn(inn);
    }
}
