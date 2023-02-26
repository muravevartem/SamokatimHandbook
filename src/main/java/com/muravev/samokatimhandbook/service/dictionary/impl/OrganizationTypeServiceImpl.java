package com.muravev.samokatimhandbook.service.dictionary.impl;

import com.muravev.samokatimhandbook.mapper.OrganizationTypeMapper;
import com.muravev.samokatimhandbook.model.dictinary.OrganizationType;
import com.muravev.samokatimhandbook.repository.OrganizationTypeRepository;
import com.muravev.samokatimhandbook.service.dictionary.OrganizationTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationTypeServiceImpl implements OrganizationTypeService {
    private final OrganizationTypeRepository organizationTypeRepository;
    private final OrganizationTypeMapper mapper;

    @Override
    public List<OrganizationType> getAll() {
        return mapper.toDto(organizationTypeRepository.findAll());
    }

}
