package com.pragma.bootcamp2024.domain.api.usecase;

import com.pragma.bootcamp2024.domain.api.ICapacityServicePort;
import com.pragma.bootcamp2024.domain.model.Capacity;
import com.pragma.bootcamp2024.domain.spi.ICapacityPersistencePort;

import java.util.List;

public class UseCaseCapacity implements ICapacityServicePort {

    private final ICapacityPersistencePort iCapacityPersistencePort;

    public UseCaseCapacity(ICapacityPersistencePort iCapacityPersistencePort) {
        this.iCapacityPersistencePort = iCapacityPersistencePort;
    }

    @Override
    public void saveCapacity(Capacity capacity) {
        iCapacityPersistencePort.saveCapacity(capacity);
    }

    @Override
    public Capacity getCapacity(String name) {
        return iCapacityPersistencePort.getcapacity(name);
    }

    @Override
    public List<Capacity> getAllCapacities(Integer page, Integer size) {
        return iCapacityPersistencePort.getAllCapacities(page, size);
    }

    @Override
    public List<Capacity> getAllCapacitiesByTechnology(String technology, Integer page, Integer size) {
        return iCapacityPersistencePort.getAllCapacitiesByTechnology(technology, page, size);
    }

    @Override
    public Capacity updateCapacity(Capacity capacity) {
        return iCapacityPersistencePort.updateCapacity(capacity);
    }

    @Override
    public void deleteCapacity(Long id) {
        iCapacityPersistencePort.deleteCapacity(id);
    }
}
