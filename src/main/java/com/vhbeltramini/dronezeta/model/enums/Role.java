package com.vhbeltramini.dronezeta.model.enums;

public enum Role {

    ADMIN(1, "admin"),
    CLIENT(2, "client");

    private final int id;
    private final String description;

    Role(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
