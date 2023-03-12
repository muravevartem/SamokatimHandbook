package com.muravev.samokatimhandbook.repository;

import com.muravev.samokatimhandbook.entity.OrganizationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Long> {
    Optional<OrganizationEntity> findByInn(String inn);

    @Query("""
            SELECT org FROM OrganizationEntity org
            WHERE lower(org.name) LIKE CONCAT('%',lower(?1),'%')
            """)
    Page<OrganizationEntity> findByKeyword(@Param("keyword") String keyword, Pageable pageable);
}
