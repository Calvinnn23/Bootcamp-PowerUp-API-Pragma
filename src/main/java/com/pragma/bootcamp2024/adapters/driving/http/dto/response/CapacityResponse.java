package com.pragma.bootcamp2024.adapters.driving.http.dto.response;

import com.pragma.bootcamp2024.domain.model.Technology;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CapacityResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final List<Technology> technologies;
}
