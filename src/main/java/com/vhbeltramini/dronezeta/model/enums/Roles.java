package com.vhbeltramini.dronezeta.model.enums;

public enum Roles {

    ADMIN(1, "admin"),
    CLIENT(1, "admin");

    private final int id;
    private final String description;

    Roles(int id, String description) {
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
