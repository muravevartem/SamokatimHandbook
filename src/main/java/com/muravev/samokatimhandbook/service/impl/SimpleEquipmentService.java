package com.muravev.samokatimhandbook.service.impl;

import com.muravev.samokatimhandbook.entity.equipment.EquipmentEntity;
import com.muravev.samokatimhandbook.error.ApiException;
import com.muravev.samokatimhandbook.error.StatusCode;
import com.muravev.samokatimhandbook.mapper.EquipmentMapper;
import com.muravev.samokatimhandbook.model.request.equipment.EquipmentRequest;
import com.muravev.samokatimhandbook.model.response.equipment.Equipment;
import com.muravev.samokatimhandbook.model.response.equipment.EquipmentAttribute;
import com.muravev.samokatimhandbook.model.response.equipment.EquipmentParameter;
import com.muravev.samokatimhandbook.repository.EquipmentAttributeRepository;
import com.muravev.samokatimhandbook.repository.EquipmentRepository;
import com.muravev.samokatimhandbook.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SimpleEquipmentService implements EquipmentService {
    private final EquipmentRepository repository;
    private final EquipmentAttributeRepository attributeRepository;
    private final EquipmentMapper mapper;


    @Override
    public Page<Equipment> getAll(Pageable pageable) {
        var equipments = repository.findAll(pageable);
        return equipments.map(mapper::toDto);
    }

    @Override
    public Equipment getOne(long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new ApiException(StatusCode.EQUIPMENT_NOT_FOUND));
    }

    @Override
    public List<EquipmentAttribute> getAllAttributes(String keyword) {
        return attributeRepository.findAllByKeyword(keyword).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EquipmentParameter> getAllParameters(long equipmentId) {
        var parameters = repository.findById(equipmentId)
                .map(EquipmentEntity::getParameters)
                .orElseThrow(() -> new ApiException(StatusCode.EQUIPMENT_NOT_FOUND));
        return parameters.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Equipment create(EquipmentRequest equipmentRequest) {
        var mappedEquipmentEntity = mapper.toEntity(equipmentRequest);
        var savedEquipment = repository.save(mappedEquipmentEntity);
        return mapper.toDto(savedEquipment);
    }

    @Override
    public Equipment update(long equipmentId, EquipmentRequest equipmentRequest) {
        var equipment = repository.findById(equipmentId)
                .orElseThrow(() -> new ApiException(StatusCode.EQUIPMENT_NOT_FOUND));
        var mappedEquipment = mapper.toEntity(equipmentRequest);
        var updatedEquipment = mapper.merge(equipment, mappedEquipment);
        var savedEquipment = repository.save(updatedEquipment);
        return mapper.toDto(savedEquipment);
    }

    @Override
    public void delete(long equipmentId) {
        var equipment = repository.findById(equipmentId)
                .orElseThrow(() -> new ApiException(StatusCode.EQUIPMENT_NOT_FOUND));
        repository.delete(equipment);
    }

}
