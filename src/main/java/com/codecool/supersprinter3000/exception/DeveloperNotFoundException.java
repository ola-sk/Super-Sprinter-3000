package com.codecool.supersprinter3000.exception;

import java.util.UUID;

public class DeveloperNotFoundException extends RuntimeException {
    public DeveloperNotFoundException(UUID uuid) {
        super("Developer with id " + uuid + " not found");
    }
}