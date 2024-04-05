package com.pragma.bootcamp2024.adapters.driving.http.mapper;

import com.pragma.bootcamp2024.adapters.driving.http.dto.request.AddCapacityRequest;
import com.pragma.bootcamp2024.adapters.driving.http.dto.request.UpdateCapacityRequest;
import com.pragma.bootcamp2024.domain.model.Capacity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.validation.Valid;

@Mapper(componentModel = "spring")
public interface ICapacityRequestMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "technologies", target = "technologies")
    Capacity addRequestToCapacity(AddCapacityRequest addCapacityRequest);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "technologies", target = "technologies")
    Capacity updateRequestToCapacity(@Valid UpdateCapacityRequest updateCapacityRequest);
}