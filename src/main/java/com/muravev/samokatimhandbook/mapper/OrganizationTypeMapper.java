package com.muravev.samokatimhandbook.mapper;

import com.muravev.samokatimhandbook.entity.dictionary.OrganizationTypeEntity;
import com.muravev.samokatimhandbook.model.dictinary.OrganizationType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface OrganizationTypeMapper {

    OrganizationType toDto(OrganizationTypeEntity entity);

    List<OrganizationType> toDto(Collection<OrganizationTypeEntity> entities);

    OrganizationTypeEntity toEntity(OrganizationType dto);

}
