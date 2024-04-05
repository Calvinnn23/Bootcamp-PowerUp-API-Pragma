package com.pragma.bootcamp2024.domain.api.usecase;

import com.pragma.bootcamp2024.domain.model.Technology;
import com.pragma.bootcamp2024.domain.api.ITechnologyServicePort;
import com.pragma.bootcamp2024.domain.spi.ITechnologyPersistencePort;

import java.util.List;

public class UseCaseTechnology implements ITechnologyServicePort {
    private final ITechnologyPersistencePort iTechnologyPersistencePort;

    public UseCaseTechnology(ITechnologyPersistencePort iTechnologyPersistencePort) {
        this.iTechnologyPersistencePort = iTechnologyPersistencePort;
    }

    @Override
    public void saveTechnology(Technology technology) {
        iTechnologyPersistencePort.saveTechnology(technology);
    }

    @Override
    public Technology getTechnology(String name) {
        return iTechnologyPersistencePort.getTechnology(name);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size) {
        return iTechnologyPersistencePort.getAllTechnologies(page, size);
    }

    @Override
    public List<Technology> getAllTechnologiesByCapacity(String capacity, Integer page, Integer size) {
        return iTechnologyPersistencePort.getAllTechnologiesByCapacity(capacity, page, size);
    }

    @Override
    public Technology updateTechnology(Technology technology) {
        return iTechnologyPersistencePort.updateTechnology(technology);
    }

    @Override
    public void deleteProduct(Long id) {
        iTechnologyPersistencePort.deleteTechnology(id);
    }
}
