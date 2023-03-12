package com.muravev.samokatimhandbook.intergration.fns.mapper;

import com.muravev.samokatimhandbook.entity.OrganizationEntity;
import com.muravev.samokatimhandbook.intergration.fns.model.DaDataOrganization;
import com.muravev.samokatimhandbook.intergration.fns.model.DaDataOrganizationData;
import com.muravev.samokatimhandbook.model.response.Organization;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DaDataOrganizationMapper {

    @Mapping(target = "inn", source = "data.inn")
    OrganizationEntity toEntity(DaDataOrganization model);

    @Mapping(target = "inn", source = "data.inn")
    Organization toOrganization(DaDataOrganization model);
}
