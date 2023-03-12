package com.muravev.samokatimhandbook.service;

import com.muravev.samokatimhandbook.model.request.equipment.EquipmentRequest;
import com.muravev.samokatimhandbook.model.response.equipment.Equipment;
import com.muravev.samokatimhandbook.model.response.equipment.EquipmentAttribute;
import com.muravev.samokatimhandbook.model.response.equipment.EquipmentParameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EquipmentService {
    Page<Equipment> getAll(Pageable pageable);

    Equipment getOne(long id);

    List<EquipmentAttribute> getAllAttributes(String keyword);

    List<EquipmentParameter> getAllParameters(long equipmentId);

    Equipment create(EquipmentRequest equipment);

    Equipment update(long equipmentId, EquipmentRequest equipmentRequest);

    void delete(long equipmentId);
}
