package com.muravev.samokatimhandbook.mapper;

import com.muravev.samokatimhandbook.entity.OrganizationEntity;
import com.muravev.samokatimhandbook.model.request.OrganizationRequest;
import com.muravev.samokatimhandbook.model.response.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface OrganizationMapper {

    Organization toDto(OrganizationEntity entity);

    OrganizationEntity toEntity(OrganizationRequest dto);

    @Mapping(target = "id", ignore = true)
    OrganizationEntity mergeEntity(@MappingTarget OrganizationEntity entity, OrganizationRequest dto);

}
