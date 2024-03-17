package com.pragma.bootcamp2024.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddTechnologyRequest {
    private final String nameTechnology;
    private final String descriptionTechnology;
}
