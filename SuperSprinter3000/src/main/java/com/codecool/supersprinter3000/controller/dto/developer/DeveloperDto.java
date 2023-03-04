package com.codecool.supersprinter3000.controller.dto.developer;

import java.util.UUID;

public record DeveloperDto(
        UUID id,
        String firstName,
        String lastName,
        String email
) {
}
