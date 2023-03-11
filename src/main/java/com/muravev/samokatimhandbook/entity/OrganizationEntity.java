package com.muravev.samokatimhandbook.entity;

import com.muravev.samokatimhandbook.model.response.OrganizationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Set;

@Entity
@Table(name = "organization")
@Getter
@Setter
public class OrganizationEntity extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_organization")
    @SequenceGenerator(name = "seq_organization", sequenceName = "seq_organization", allocationSize = 1)
    private Long id;

    private String name;

    private String fullName;

    @Column(unique = true)
    private String inn;

    @Enumerated(EnumType.STRING)
    private OrganizationStatus status = OrganizationStatus.PENDING;

    private String tel;

    private String email;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EquipmentEntity> equipments;

}
