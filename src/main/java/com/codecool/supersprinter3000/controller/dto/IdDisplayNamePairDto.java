package com.codecool.supersprinter3000.controller.dto;

import java.util.UUID;

public record IdDisplayNamePairDto(
        UUID id,
        String displayName
) {
}
