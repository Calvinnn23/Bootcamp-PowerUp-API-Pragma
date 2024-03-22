package com.pragma.bootcamp2024.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TechnologyResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final Long capacityId;
    private final String capacity;
}
