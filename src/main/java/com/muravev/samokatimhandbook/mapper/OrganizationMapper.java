package com.muravev.samokatimhandbook.mapper;

import com.muravev.samokatimhandbook.entity.OrganizationEntity;
import com.muravev.samokatimhandbook.model.response.Organization;
import org.mapstruct.Mapper;

@Mapper
public interface OrganizationMapper {

    Organization toDto(OrganizationEntity entity);

    OrganizationEntity toEntity(Organization dto);

}
