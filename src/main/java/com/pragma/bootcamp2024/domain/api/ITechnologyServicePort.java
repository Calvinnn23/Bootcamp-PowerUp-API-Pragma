package com.pragma.bootcamp2024.domain.api;

import com.pragma.bootcamp2024.domain.model.Technology;

import java.util.List;

public interface ITechnologyServicePort {
    void saveTechnology(Technology technology);

    Technology getTechnology(String name);

    List<Technology> getAllTechnologies(Integer page, Integer size);

    List<Technology> getAllTechnologiesByCapacity(String capacity, Integer page, Integer size);

    Technology updateTechnology(Technology technology);

    void deleteProduct(Long id);
}