package com.pragma.bootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.*;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.bootcamp2024.domain.model.Capacity;
import com.pragma.bootcamp2024.domain.model.Technology;
import com.pragma.bootcamp2024.domain.spi.ICapacityPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CapacityAdapter implements ICapacityPersistencePort {
    private final ICapacityRepository iCapacityRepository;
    private final ICapacityEntityMapper iCapacityEntityMapper;
    private final ITechnologyRepository iTechnologyRepository;
    private final ITechnologyEntityMapper iTechnologyEntityMapper;

    @Override
    public void saveCapacity(Capacity capacity) {
        if (iCapacityRepository.findByName(capacity.getName()).isPresent()) {
            throw new CapacityAlreadyExistsException();
        }
        CapacityEntity capacityEntity = iCapacityEntityMapper.toEntity(capacity);
        List<TechnologyEntity> technologyEntities = new ArrayList<>();
        for (Technology technology : capacity.getTechnologies()) {
            TechnologyEntity technologyEntity = iTechnologyRepository.findById(technology.getId())
                    .orElseThrow(TechnologyNotFoundException::new);
            technologyEntities.add(technologyEntity);
        }
        capacityEntity.setTechnologies(technologyEntities);
        iCapacityRepository.save(capacityEntity);
    }

    @Override
    public Capacity getcapacity(String name) {
        CapacityEntity capacityEntity = iCapacityRepository.findByNameContaining(name)
                .orElseThrow(CapacityNotFoundException::new);
        return iCapacityEntityMapper.toModel(capacityEntity);
    }

    @Override
    public List<Capacity> getAllCapacities(Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<CapacityEntity> capacityEntities = iCapacityRepository.findAll(pagination).getContent();
        if (capacityEntities.isEmpty()) {
            throw new NoDataFoundException();
        }
        return iCapacityEntityMapper.toModelList(capacityEntities);
    }

    @Override
    public List<Capacity> getAllCapacitiesByTechnology(String technology, Integer page, Integer size) {
        Pageable pagination = PageRequest.of(page, size);
        List<CapacityEntity> capacityEntities = iCapacityRepository.findAllByTechnologyNameContaining(technology, pagination).getContent();
        if (capacityEntities.isEmpty()) {
            throw new NoDataFoundException();
        }
        return iCapacityEntityMapper.toModelList(capacityEntities);
    }

    @Override
    public Capacity updateCapacity(Capacity capacity) {
        if (iCapacityRepository.findById(capacity.getId()).isEmpty()) {
            throw new CapacityNotFoundException();
        }
        return iCapacityEntityMapper.toModel(iCapacityRepository.save(iCapacityEntityMapper.toEntity(capacity)));
    }

    @Override
    public void deleteCapacity(Long id) {
        if (iCapacityRepository.findById(id).isEmpty()) {
            throw new CapacityNotFoundException();
        }
        iCapacityRepository.deleteById(id);
    }

}
