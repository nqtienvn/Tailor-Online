package com.tien.tai.infrastructor.persistence.model;

public enum Gender {
    MALE, FEMALE, OTHER;

    public Gender fromString(String value) {
        if (value == null) return null;
        value = value.trim().toUpperCase();
        return switch (value) {
            case "MALE", "NAM" -> MALE;
            case "FEMALE", "NU", "NỮ" -> FEMALE;
            default -> OTHER;
        };
    }
}
