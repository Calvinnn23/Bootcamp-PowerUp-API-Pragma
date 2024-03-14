package com.pragma.bootcamp2024.domain.api;

import com.pragma.bootcamp2024.domain.model.Technology;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
public interface TechnologyServicePort
{
    void saveTechnology(Technology technology);
    Technology getTechnology(String nameTechnology);
    List<Technology> getAllTechnologies(Integer page, Integer size);
}