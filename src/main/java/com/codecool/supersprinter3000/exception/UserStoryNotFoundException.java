package com.codecool.supersprinter3000.exception;

import java.util.UUID;

public class UserStoryNotFoundException extends RuntimeException {
    public UserStoryNotFoundException(UUID uuid) {
        super("User story with id " + uuid + " not found");
    }
}