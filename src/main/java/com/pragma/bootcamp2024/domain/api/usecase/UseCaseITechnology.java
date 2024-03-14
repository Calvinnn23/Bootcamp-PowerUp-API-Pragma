package com.pragma.bootcamp2024.domain.api.usecase;

import com.pragma.bootcamp2024.domain.model.Technology;
import com.pragma.bootcamp2024.domain.api.ITechnologyServicePort;
import com.pragma.bootcamp2024.domain.spi.ITechnologyPersistencePort;
import java.util.List;
public class UseCaseITechnology implements ITechnologyServicePort
{
    private final ITechnologyPersistencePort ITechnologyPersistencePort;
    public UseCaseITechnology(ITechnologyPersistencePort ITechnologyPersistencePort)
    {
        this.ITechnologyPersistencePort = ITechnologyPersistencePort;
    }

    @Override
    public void saveTechnology(Technology technology)
    {
        ITechnologyPersistencePort.saveTechnology(technology);
    }

    @Override
    public Technology getTechnology(String nameTechnology)
    {
       return ITechnologyPersistencePort.getTechnology(nameTechnology);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size)
    {
        return ITechnologyPersistencePort.getAllTechnologies(page, size);
    }   
}
