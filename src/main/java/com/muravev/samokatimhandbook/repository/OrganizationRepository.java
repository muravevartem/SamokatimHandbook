package com.muravev.samokatimhandbook.repository;

import com.muravev.samokatimhandbook.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
    Optional<OrganizationEntity> findByInn(String inn);
}
