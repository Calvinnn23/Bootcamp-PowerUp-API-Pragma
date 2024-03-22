package com.pragma.bootcamp2024.adapters.driving.http.dto.request;

import com.pragma.bootcamp2024.domain.exception.EmptyFieldException;
import com.pragma.bootcamp2024.domain.model.Capacity;
import com.pragma.bootcamp2024.domain.util.DomainConstans;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static java.util.Objects.requireNonNull;

@AllArgsConstructor
@Getter
@Validated
public class AddTechnologyRequest {
    @NotBlank(message = DomainConstans.FIELD_NAME_NULL_MESSAGE)
    @Size(max = 50, message = DomainConstans.FIELD_NAME_OUT_OF_BOUNDS_MESSAGE)
    private final String name;

    @NotBlank(message = DomainConstans.FIELD_DESCRIPTION_NULL_MESSAGE)
    @Size(max = 90, message = DomainConstans.FIELD_DESCRIPTION_OUT_OF_BOUNDS_MESSAGE)
    private final String description;

    @NotNull(message = DomainConstans.FIELD_CAPACITY_NULL_MESSAGE)
    private final Long capacityId;

    public AddTechnologyRequest(String name, String description, Capacity capacityId) {

        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstans.Field.NAME.toString());
        }

        if (description.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstans.Field.DESCRIPTION.toString());
        }

        this.name = name;
        this.description = description;
        this.capacityId = requireNonNull(capacityId.getId(), DomainConstans.FIELD_CAPACITY_NULL_MESSAGE);

    }
}
