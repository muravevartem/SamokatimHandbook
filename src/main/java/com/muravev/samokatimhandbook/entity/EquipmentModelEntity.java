package com.muravev.samokatimhandbook.entity;


import com.muravev.samokatimhandbook.model.EquipmentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "equipment_model")
@Getter
@Setter
public class EquipmentModelEntity extends AbstractEntity<Long> {

    @Id
    @SequenceGenerator(name = "seq_equipment_model", sequenceName = "seq_equipment_model")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_equipment_model")
    public Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EquipmentType type;

}
