package com.pragma.bootcamp2024.domain.spi;

import com.pragma.bootcamp2024.domain.model.Technology;
import org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator;

import java.util.List;

public interface ITechnologyPersistencePort {
    void saveTechnology(Technology technology);

    Technology getTechnology(String name);

    List<Technology> getAllTechnologies(Integer page, Integer size);

    List<Technology> getAllTechnologiesByCapacity(String capacity, Integer page, Integer size);

    Technology updateTechnology(Technology technology);

    void deleteTechnology(Long id);
}