package com.muravev.samokatimhandbook.repository;

import com.muravev.samokatimhandbook.entity.equipment.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<EquipmentEntity, Long> {
}
