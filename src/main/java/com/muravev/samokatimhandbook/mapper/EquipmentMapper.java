package com.muravev.samokatimhandbook.mapper;

import com.muravev.samokatimhandbook.entity.equipment.EquipmentAttributeEntity;
import com.muravev.samokatimhandbook.entity.equipment.EquipmentEntity;
import com.muravev.samokatimhandbook.entity.equipment.EquipmentParameterEntity;
import com.muravev.samokatimhandbook.model.request.equipment.EquipmentParameterRequest;
import com.muravev.samokatimhandbook.model.request.equipment.EquipmentRequest;
import com.muravev.samokatimhandbook.model.response.equipment.Equipment;
import com.muravev.samokatimhandbook.model.response.equipment.EquipmentAttribute;
import com.muravev.samokatimhandbook.model.response.equipment.EquipmentParameter;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import static org.mapstruct.CollectionMappingStrategy.TARGET_IMMUTABLE;

@Mapper(
        uses = OrganizationMapper.class,
        collectionMappingStrategy = TARGET_IMMUTABLE
)
public interface EquipmentMapper {

    @Mapping(target = "owner.id", source = "ownerId")
    EquipmentEntity toEntity(EquipmentRequest request);

    @Mapping(target = "id", ignore = true)
    EquipmentEntity merge(@MappingTarget EquipmentEntity entity, EquipmentEntity equipmentRequest);

    @Mapping(target = "attribute.id", source = "attributeId")
    EquipmentParameterEntity toEntity(EquipmentParameterRequest request);

    Equipment toDto(EquipmentEntity entity);

    EquipmentAttribute toDto(EquipmentAttributeEntity entity);

    EquipmentParameter toDto(EquipmentParameterEntity entity);

}
