package com.muravev.samokatimhandbook.entity.equipment;

import com.muravev.samokatimhandbook.entity.AbstractEntity;
import com.muravev.samokatimhandbook.entity.OrganizationEntity;
import com.muravev.samokatimhandbook.model.response.equipment.EquipmentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "equipment")
@Getter
@Setter
public class EquipmentEntity extends AbstractEntity<Long> {

    @Id
    @SequenceGenerator(name = "seq_equipment", sequenceName = "seq_equipment")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_equipment")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EquipmentParameterEntity> parameters = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "org_id")
    private OrganizationEntity owner;

    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;


    public void setParameters(Set<EquipmentParameterEntity> parameters) {
        if (parameters != null) {
            this.parameters.clear();
            this.parameters.addAll(parameters);
            this.parameters.forEach(parameter -> parameter.setEquipment(this));
        }
    }
}
