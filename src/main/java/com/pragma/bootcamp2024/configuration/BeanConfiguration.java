package com.pragma.bootcamp2024.configuration;

import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.adapter.CapacityAdapter;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.adapter.TechnologyAdapter;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.mapper.ICapacityEntityMapper;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.mapper.ITechnologyEntityMapper;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.repository.ICapacityRepository;
import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.repository.ITechnologyRepository;
import com.pragma.bootcamp2024.domain.api.ICapacityServicePort;
import com.pragma.bootcamp2024.domain.api.ITechnologyServicePort;
import com.pragma.bootcamp2024.domain.api.usecase.UseCaseCapacity;
import com.pragma.bootcamp2024.domain.api.usecase.UseCaseTechnology;
import com.pragma.bootcamp2024.domain.spi.ICapacityPersistencePort;
import com.pragma.bootcamp2024.domain.spi.ITechnologyPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final ITechnologyRepository iTechnologyRepository;
    private final ITechnologyEntityMapper iTechnologyEntityMapper;
    private final ICapacityRepository iCapacityRepository;
    private final ICapacityEntityMapper iCapacityEntityMapper;

    @Bean
    public ITechnologyPersistencePort technologyPersistencePort() {
        return new TechnologyAdapter(iTechnologyRepository, iTechnologyEntityMapper, iCapacityRepository, iCapacityEntityMapper);
    }

    @Bean
    public ITechnologyServicePort technologyServicePort() {
        return new UseCaseTechnology(technologyPersistencePort());
    }

    @Bean
    public ICapacityPersistencePort capacityPersistencePort() {
        return new CapacityAdapter(iCapacityRepository, iCapacityEntityMapper);
    }

    @Bean
    public ICapacityServicePort capacityServicePort() {
        return new UseCaseCapacity(capacityPersistencePort());
    }
}
