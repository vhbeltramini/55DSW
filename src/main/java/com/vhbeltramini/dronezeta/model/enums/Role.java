package com.vhbeltramini.dronezeta.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Objects;

public enum Role {

    ADMIN(1, "admin"),
    CLIENT(2, "client");

    private final int key;
    private final String description;

    Role(int id, String description) {
        this.key = id;
        this.description = description;
    }

    @JsonValue
    public int getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public static Role fromKey(int key) {
        for (Role role : values()) {
            if (role.key == key) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role key: " + key);
    }

    @JsonCreator
    public static Role fromDescription(String description) {
        for (Role role : values()) {
            if (Objects.equals(role.description, description)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + description);
    }





}
