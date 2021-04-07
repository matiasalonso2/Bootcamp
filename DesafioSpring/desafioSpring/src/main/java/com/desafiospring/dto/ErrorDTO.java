package com.desafiospring.dto;

public class ErrorDTO {
    private String name;
    private String description;

    public ErrorDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
