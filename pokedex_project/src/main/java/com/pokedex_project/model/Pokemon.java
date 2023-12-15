package com.pokedex_project.model;


import jakarta.validation.constraints.*;

public class Pokemon {

    @NotNull(message="is required")
    private String name;

    public Pokemon() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                '}';
    }
}
