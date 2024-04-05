package com.pragma.bootcamp2024.adapters.driving.http.dto.request;

import com.pragma.bootcamp2024.domain.model.Capacity;
import com.pragma.bootcamp2024.domain.model.Technology;
import com.pragma.bootcamp2024.domain.util.DomainConstans;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@Getter
public class AddTechnologyRequest {
    @NotNull(message = DomainConstans.FIELD_NAME_NULL_MESSAGE)
    @Size(max = 50, message = DomainConstans.FIELD_NAME_OUT_OF_BOUNDS_MESSAGE)
    private final String name;

    @NotNull(message = DomainConstans.FIELD_DESCRIPTION_NULL_MESSAGE)
    @Size(max = 90, message = DomainConstans.FIELD_DESCRIPTION_OUT_OF_BOUNDS_MESSAGE)
    private final String description;

    @NotNull(message = DomainConstans.FIELD_CAPACITY_NULL_MESSAGE)
    private List<Capacity> capacities;
}
