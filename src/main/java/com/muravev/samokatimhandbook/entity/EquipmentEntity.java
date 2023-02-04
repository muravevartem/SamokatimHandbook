package com.muravev.samokatimhandbook.entity;

import com.muravev.samokatimhandbook.model.EquipmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipment")
@Getter
@Setter
public class EquipmentEntity extends AbstractEntity<Long> {

    @Id
    @SequenceGenerator(name = "seq_equipment", sequenceName = "seq_equipment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_equipment")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizationEntity owner;

    @ManyToOne
    @JoinColumn(name = "model_id")
    private EquipmentModelEntity model;

    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;

}
