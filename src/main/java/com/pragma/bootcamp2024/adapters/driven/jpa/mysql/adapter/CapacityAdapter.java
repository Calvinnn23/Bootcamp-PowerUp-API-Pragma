package com.pragma.bootcamp2024.adapters.driven.jpa.mysql.adapter;

import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.CapacityAlreadyExistsException;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.exception.NoDataFoundException;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.pragma.bootcamp2024.domain.model.Capacity;
import com.pragma.bootcamp2024.domain.spi.ICapacityPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CapacityAdapter implements ICapacityPersistencePort {
    private final ICapacityRepository iCapacityRepository;
    private final ICapacityEntityMapper iCapacityEntityMapper;

    @Override
    public void addCapacity(Capacity capacity) {
        if (iCapacityRepository.findByName(capacity.getName()).isPresent()) {
            throw new CapacityAlreadyExistsException();
        }
        iCapacityRepository.save(iCapacityEntityMapper.toEntity(capacity));
    }

    @Override
    public List<Capacity> getAllCapacities() {
        List<CapacityEntity> capacityEntities = iCapacityRepository.findAll();
        if (capacityEntities.isEmpty()) {
            throw new NoDataFoundException();
        }
        return iCapacityEntityMapper.toModelList(capacityEntities);
    }
}
