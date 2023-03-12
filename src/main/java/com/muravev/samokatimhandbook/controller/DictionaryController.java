package com.muravev.samokatimhandbook.controller;

import com.muravev.samokatimhandbook.model.dictinary.OrganizationType;
import com.muravev.samokatimhandbook.model.response.equipment.EquipmentAttribute;
import com.muravev.samokatimhandbook.service.EquipmentService;
import com.muravev.samokatimhandbook.service.dictionary.OrganizationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dictionaries")
@RequiredArgsConstructor
public class DictionaryController {
    private final OrganizationTypeService organizationTypeService;
    private final EquipmentService equipmentService;


    @GetMapping("/organization-types")
    public Iterable<OrganizationType> getAllOrganizationTypes() {
        return organizationTypeService.getAll();
    }

    @GetMapping("/equipment-attributes")
    public Iterable<EquipmentAttribute> getAllEquipmentAttributes(@RequestParam("t") String keyword) {
        return equipmentService.getAllAttributes(keyword);
    }
}
