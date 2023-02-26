package com.muravev.samokatimhandbook.repository;

import com.muravev.samokatimhandbook.entity.dictionary.OrganizationTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationTypeRepository extends JpaRepository<OrganizationTypeEntity, Long> {
}
