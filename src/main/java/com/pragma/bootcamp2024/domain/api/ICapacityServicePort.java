package com.pragma.bootcamp2024.domain.api;

import com.pragma.bootcamp2024.domain.model.Capacity;

import java.util.List;

public interface ICapacityServicePort {
    void addCapacity(Capacity capacity);

    List<Capacity> getAllCapacities();
}
