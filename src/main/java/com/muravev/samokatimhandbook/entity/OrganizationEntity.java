package com.muravev.samokatimhandbook.entity;

import com.muravev.samokatimhandbook.model.response.OrganizationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "organization")
@Getter
@Setter
public class OrganizationEntity extends AbstractEntity<Long> {

    @Id
    @SequenceGenerator(name = "seq_organization", sequenceName = "seq_organization")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_organization")
    private Long id;

    private String name;

    private String fullName;

    private String inn;

    @Enumerated(EnumType.STRING)
    private OrganizationStatus status;

    private String tel;
    private String email;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            joinColumns = @JoinColumn(name = "org_id"),
            inverseJoinColumns = @JoinColumn(name = "admin_id"),
            name = "org_admin"
    )
    private Set<UserEntity> admins;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            joinColumns = @JoinColumn(name = "org_id"),
            inverseJoinColumns = @JoinColumn(name = "lead_id"),
            name = "org_lead"
    )
    private Set<UserEntity> leaders;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EquipmentEntity> equipments;

}
