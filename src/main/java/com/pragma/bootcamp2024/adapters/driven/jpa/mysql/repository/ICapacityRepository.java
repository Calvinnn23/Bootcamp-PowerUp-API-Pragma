package com.pragma.bootcamp2024.adapters.driven.jpa.mysql.repository;

import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.entity.CapacityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICapacityRepository extends JpaRepository<CapacityEntity, Long> {
    Optional<CapacityEntity> findByNameContaining(String name);

    Optional<CapacityEntity> findByName(String name);

    Page<CapacityEntity> findAll(Pageable pageable);

    Page<CapacityEntity> findAllByTechnologyNameContaining(String technology, Pageable pageable);
}
