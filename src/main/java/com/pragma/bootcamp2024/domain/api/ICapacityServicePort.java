package com.pragma.bootcamp2024.domain.api;

import com.pragma.bootcamp2024.domain.model.Capacity;

import java.util.List;

public interface ICapacityServicePort {
    void saveCapacity(Capacity capacity);

    Capacity getCapacity(String name);

    List<Capacity> getAllCapacities(Integer page, Integer size);

    List<Capacity> getAllCapacitiesByTechnology(String technology, Integer page, Integer size);

    Capacity updateCapacity(Capacity capacity);

    void deleteCapacity(Long id);
}
