package com.muravev.samokatimhandbook.entity.equipment;

import com.muravev.samokatimhandbook.entity.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "equipment_param")
@Getter
@Setter
public class EquipmentParameterEntity  extends AbstractEntity<Long> {
    @Id
    @SequenceGenerator(name = "seq_equipment_attr", sequenceName = "seq_equipment_attr")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_equipment_attr")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "attr_id")
    private EquipmentAttributeEntity attribute;

    @ManyToOne(optional = false)
    @JoinColumn(name = "equipment_id")
    private EquipmentEntity equipment;

    private String value;

}
