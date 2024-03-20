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
    public void addCapacity(Capacity capacity) {
        iCapacityPersistencePort.addCapacity(capacity);
    }

    @Override
    public List<Capacity> getAllCapacities() {
        return iCapacityPersistencePort.getAllCapacities();
    }
}
