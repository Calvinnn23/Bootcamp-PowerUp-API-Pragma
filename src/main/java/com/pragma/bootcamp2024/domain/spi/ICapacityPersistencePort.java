package com.pragma.bootcamp2024.domain.spi;

import com.pragma.bootcamp2024.domain.model.Capacity;

import java.util.List;

public interface ICapacityPersistencePort {
    void addCapacity(Capacity capacity);

    List<Capacity> getAllCapacities();
}
