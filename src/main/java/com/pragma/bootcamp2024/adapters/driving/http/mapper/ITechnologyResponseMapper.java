package com.pragma.bootcamp2024.adapters.driving.http.mapper;

import com.pragma.bootcamp2024.adapters.driving.http.dto.response.TechnologyResponse;
import com.pragma.bootcamp2024.domain.model.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITechnologyResponseMapper {
    @Mapping(source = "capacity.id", target = "capacityId")
    @Mapping(source = "capacity.name", target = "capacity")
    TechnologyResponse toTechnologyResponse(Technology technology);

    List<TechnologyResponse> toTechnologyResponsList(List<Technology> technologies);
}
