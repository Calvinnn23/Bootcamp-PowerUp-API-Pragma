package com.pragma.bootcamp2024.util;

public final class DomainConstans {
    private DomainConstans() {
        throw new IllegalStateException("Utility class");
    }

    public enum Field {
        NAME,
        DESCRIPTION,
        NAMEMAX,
        DESCRIPTIONMAX
    }

    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'name' cannot be null";
    public static final String FIELD_NAMEMAX_OUT_OF_BOUNDS_MESSAGE = "Field 'name' is out of bounds (max 50 char)";
    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'description' cannot be null";
    public static final String FIELD_DESCRIPTIONMAX_OUT_OF_BOUNDS_MESSAGE = "Field 'description' is out of bounds (max 90 char)";
    public static final String FIELD_CAPACITY_NULL_MESSAGE = "Field 'capacity' cannot be null";
}
