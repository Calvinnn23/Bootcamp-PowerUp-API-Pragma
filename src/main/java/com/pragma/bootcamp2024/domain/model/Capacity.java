package com.pragma.bootcamp2024.domain.model;

import com.pragma.bootcamp2024.domain.exception.EmptyFieldException;
import com.pragma.bootcamp2024.domain.exception.StringOutOfBoundsException;
import com.pragma.bootcamp2024.util.DomainConstans;

import static java.util.Objects.requireNonNull;

public class Capacity {
    private final Long id;
    private final String name;
    private final String description;

    public Capacity(Long id, String name, String description) {
        this.id = id;
        if (name.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstans.Field.NAME.toString());
        } else if (name.length() > 50) {
            this.name = requireNonNull(name, DomainConstans.FIELD_NAME_NULL_MESSAGE);
            throw new StringOutOfBoundsException(DomainConstans.Field.NAMEMAX.toString());
        } else {
            this.name = requireNonNull(name, DomainConstans.FIELD_NAMEMAX_OUT_OF_BOUNDS_MESSAGE);
        }

        if (description.trim().isEmpty()) {
            throw new EmptyFieldException(DomainConstans.Field.DESCRIPTION.toString());
        } else if (description.length() > 90) {
            this.description = requireNonNull(description, DomainConstans.FIELD_DESCRIPTION_NULL_MESSAGE);
            throw new StringOutOfBoundsException(DomainConstans.Field.DESCRIPTIONMAX.toString());
        } else {
            this.description = requireNonNull(description, DomainConstans.FIELD_DESCRIPTIONMAX_OUT_OF_BOUNDS_MESSAGE);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
