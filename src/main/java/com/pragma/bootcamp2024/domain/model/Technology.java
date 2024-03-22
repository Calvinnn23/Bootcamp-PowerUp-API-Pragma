package com.pragma.bootcamp2024.domain.model;

public class Technology {
    private final Long id;
    private final String name;
    private final String description;
    private Capacity capacity;

    public Technology(Long id, String name, String description, Capacity capacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
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

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

}
