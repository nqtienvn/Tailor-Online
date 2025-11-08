package com.tien.tai.infrastructor.persistence.model;

public enum AddressType {
    HOME, WORK, OTHER;

    public AddressType fromString(String value) {
        if (value == null) return null;
        value = value.trim().toUpperCase();
        return switch (value) {
            case "HOME", "NHÀ", "NHA RIENG", "NHA", "NHÀ RIÊNG" -> HOME;
            case "WORK" -> WORK;
            default -> OTHER;
        };
    }
}
