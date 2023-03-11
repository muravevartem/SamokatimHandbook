package com.muravev.samokatimhandbook.repository;

import com.muravev.samokatimhandbook.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
}
