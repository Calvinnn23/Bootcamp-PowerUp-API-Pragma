package com.pragma.bootcamp2024.domain.spi;

import com.pragma.bootcamp2024.domain.model.Capacity;

import java.util.List;

public interface ICapacityPersistencePort {
    void saveCapacity(Capacity capacity);

    Capacity getcapacity(String name);

    List<Capacity> getAllCapacities(Integer page, Integer size);

    List<Capacity> getAllCapacitiesByTechnology(String technology, Integer page, Integer size);

    Capacity updateCapacity(Capacity capacity);

    void deleteCapacity(Long id);

}
