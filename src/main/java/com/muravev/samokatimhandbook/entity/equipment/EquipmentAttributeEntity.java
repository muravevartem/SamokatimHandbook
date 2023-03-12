package com.muravev.samokatimhandbook.entity.equipment;

import com.muravev.samokatimhandbook.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipment_attr")
@Getter
@Setter
public class EquipmentAttributeEntity extends AbstractEntity<Long> {
    @Id
    @SequenceGenerator(name = "seq_equipment_attr", sequenceName = "seq_equipment_attr")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_equipment_attr")
    private Long id;

    @Column(name = "attr_name")
    private String name;
}
