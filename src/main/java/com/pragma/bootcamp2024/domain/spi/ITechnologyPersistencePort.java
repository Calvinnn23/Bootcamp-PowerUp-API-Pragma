package com.pragma.bootcamp2024.domain.spi;

import com.pragma.bootcamp2024.domain.model.Technology;
import java.util.List;
public interface ITechnologyPersistencePort
{
    void saveTechnology(Technology technology);
    Technology getTechnology(String nameTechnology);
    List<Technology> getAllTechnologies(Integer page, Integer size);
}