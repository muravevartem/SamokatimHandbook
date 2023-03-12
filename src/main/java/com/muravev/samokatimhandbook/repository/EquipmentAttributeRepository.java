package com.muravev.samokatimhandbook.repository;

import com.muravev.samokatimhandbook.entity.equipment.EquipmentAttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EquipmentAttributeRepository extends JpaRepository<EquipmentAttributeEntity, Long> {

    @Query("""
            SELECT attr FROM EquipmentAttributeEntity attr
            WHERE lower(attr.name) LIKE '%'||lower(:keyword)||'%'
            ORDER BY attr.name
            """)
    List<EquipmentAttributeEntity> findAllByKeyword(String keyword);
}
