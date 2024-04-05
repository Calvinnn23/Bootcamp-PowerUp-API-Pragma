package com.pragma.bootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.*;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.bootcamp2024.domain.model.Technology;
import com.pragma.bootcamp2024.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class TechnologyAdapter implements ITechnologyPersistencePort {
    private final ITechnologyRepository iTechnologyRepository;
    private final ITechnologyEntityMapper iTechnologyEntityMapper;

    @Override
    public void saveTechnology(Technology technology) {
        if (iTechnologyRepository.findByName(technology.getName()).isPresent()) {
            throw new TechnologyAlreadyExistsException();
        }
        iTechnologyRepository.save(iTechnologyEntityMapper.toEntity(technology));
    }

    @Override
    public Technology getTechnology(String name) {
        TechnologyEntity technologyEntity = iTechnologyRepository.findByNameContaining(name)
                .orElseThrow(TechnologyNotFoundException::new);
        return iTechnologyEntityMapper.toModel(technologyEntity);
    }

    @Override
    public List<Technology> getAllTechnologies(Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<TechnologyEntity> technologyEntities = iTechnologyRepository.findAll(pagination).getContent();
        if (technologyEntities.isEmpty()) {
            throw new NoDataFoundException();
        }
        return iTechnologyEntityMapper.toModelList(technologyEntities);
    }

    @Override
    public List<Technology> getAllTechnologiesByCapacity(String capacity, Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<TechnologyEntity> technologyEntities = iTechnologyRepository.findAllByCapacityContaining(capacity, pagination).getContent();
        if (technologyEntities.isEmpty()) {
            throw new NoDataFoundException();
        }
        return iTechnologyEntityMapper.toModelList(technologyEntities);
    }

    @Override
    public Technology updateTechnology(Technology technology) {
        if (iTechnologyRepository.findById(technology.getId()).isEmpty()) {
            throw new TechnologyNotFoundException();
        }
        return iTechnologyEntityMapper.toModel(iTechnologyRepository.save(iTechnologyEntityMapper.toEntity(technology)));
    }

    @Override
    public void deleteTechnology(Long id) {
        if (iTechnologyRepository.findById(id).isEmpty()) {
            throw new TechnologyNotFoundException();
        }
        iTechnologyRepository.deleteById(id);
    }
}
