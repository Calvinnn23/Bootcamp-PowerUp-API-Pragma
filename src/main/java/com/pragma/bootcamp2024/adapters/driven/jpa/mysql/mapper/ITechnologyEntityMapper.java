package com.pragma.bootcamp2024.adapters.driven.jpa.mysql.mapper;


import com.pragma.bootcamp2024.adapters.driven.jpa.mysql.entity.TechnologyEntity;
import com.pragma.bootcamp2024.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITechnologyEntityMapper {
    @Mapping(source = "capacity.id", target = "capacity.id")
    @Mapping(source = "capacity.name", target = "capacity.name")
    @Mapping(source = "capacity.description", target = "capacity.description")
    Technology toModel(TechnologyEntity technologyEntity);

    @Mapping(source = "capacity.id", target = "capacity.id")
    @Mapping(source = "capacity.name", target = "capacity.name")
    @Mapping(source = "capacity.description", target = "capacity.description")
    TechnologyEntity toEntity(Technology technology);

    List<Technology> toModelList(List<TechnologyEntity> technologyEntities);
}
