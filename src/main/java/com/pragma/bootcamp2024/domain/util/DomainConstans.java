package com.pragma.bootcamp2024.domain.util;

public final class DomainConstans {
    private DomainConstans() {
        throw new IllegalStateException("Utility class");
    }

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' cannot be null";
    public static final String FIELD_NAME_OUT_OF_BOUNDS_MESSAGE = "Field 'name' is out of bounds (max 50 char)";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' cannot be null";
    public static final String FIELD_DESCRIPTION_OUT_OF_BOUNDS_MESSAGE = "Field 'description' is out of bounds (max 90 char)";
    public static final String FIELD_CAPACITY_NULL_MESSAGE = "Field 'capacity' cannot be null";
    public static final String FIELD_TECHNOLOGY_NULL_MESSAGE = "Field 'technology' cannot be null";
}
