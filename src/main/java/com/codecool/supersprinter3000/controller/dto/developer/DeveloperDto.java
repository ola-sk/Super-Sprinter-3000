package com.codecool.supersprinter3000.controller.dto.developer;


import com.codecool.supersprinter3000.controller.dto.IdDisplayNamePairDto;

import java.util.List;
import java.util.UUID;

public record DeveloperDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        List<IdDisplayNamePairDto> userStories
) {
}
