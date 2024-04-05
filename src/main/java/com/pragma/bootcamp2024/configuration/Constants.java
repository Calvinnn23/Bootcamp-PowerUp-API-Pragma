package com.pragma.bootcamp2024.configuration;

public class Constants {

    private Constants() {
        throw new IllegalStateException("utility class");
    }

    public static final String EMPTY_FIELD_EXCEPTION_MESSAGE = "Field %s can not be empty";
    public static final String STRING_OUT_OF_BOUNDS_MESSAGE = "Field %s is out of bounds";
    public static final String NO_DATA_FOUND_EXCEPTION_MESSAGE = "No data was found in the database";
    public static final String ELEMENT_NOT_FOUND_EXCEPTION_MESSAGE = "The element indicated does not exist";
    public static final String TECHNOLOGY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The technology you want to create already exists";
    public static final String TECHNOLOGY_NOT_FOUND_EXCEPTION_MESSAGE = "The technology does not exist";
    public static final String CAPACITY_ALREADY_EXISTS_EXCEPTION_MESSAGE = "The capacity you want to create already exists";
    public static final String CAPACITY_NOT_FOUND_EXCEPTION_MESSAGE = "The capacity does not exist";
}
