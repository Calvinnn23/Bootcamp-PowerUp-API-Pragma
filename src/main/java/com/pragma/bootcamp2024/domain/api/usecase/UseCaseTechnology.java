package com.pragma.bootcamp2024.domain.api.usecase;

import com.pragma.bootcamp2024.domain.model.Technology;
import com.pragma.bootcamp2024.domain.api.TechnologyServicePort;
import com.pragma.bootcamp2024.domain.spi.TechnologyPersistencePort;
import java.util.List;
public class UseCaseTechnology implements TechnologyServicePort
{
    private final TechnologyPersistencePort technologyPersistencePort;
    public UseCaseTechnology(TechnologyPersistencePort technologyPersistencePort)
    {
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public void saveTechnology(Technology technology)
    {
        technologyPersistencePort.saveTechnology(technology);
    }

    @Override
    public Technology getTechnology(String nameTechnology)
    {
       return technologyPersistencePort.getTechnology(nameTechnology);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size)
    {
        return technologyPersistencePort.getAllTechnologies(page, size);
    }
}
