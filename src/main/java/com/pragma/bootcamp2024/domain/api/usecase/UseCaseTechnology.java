package com.pragma.bootcamp2024.domain.api.usecase;

import com.pragma.bootcamp2024.domain.model.Technology;
import com.pragma.bootcamp2024.domain.api.ITechnologyServicePort;
import com.pragma.bootcamp2024.domain.spi.ITechnologyPersistencePort;

import java.util.List;

public class UseCaseTechnology implements ITechnologyServicePort {
    private final ITechnologyPersistencePort technologyPersistencePort;

    public UseCaseTechnology(ITechnologyPersistencePort iTechnologyPersistencePort) {
        this.technologyPersistencePort = iTechnologyPersistencePort;
    }

    @Override
    public void saveTechnology(Technology technology) {
        technologyPersistencePort.saveTechnology(technology);
    }

    @Override
    public Technology getTechnology(String name) {
        return technologyPersistencePort.getTechnology(name);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size) {
        return technologyPersistencePort.getAllTechnologies(page, size);
    }

    @Override
    public List<Technology> getAllTechnologiesByCapacity(String capacity, Integer page, Integer size) {
        return technologyPersistencePort.getAllTechnologiesByCapacity(capacity, page, size);
    }

    @Override
    public Technology updateTechnology(Technology technology) {
        return technologyPersistencePort.updateTechnology(technology);
    }

    @Override
    public void deleteProduct(Long id) {
        technologyPersistencePort.deleteTechnology(id);
    }
}
