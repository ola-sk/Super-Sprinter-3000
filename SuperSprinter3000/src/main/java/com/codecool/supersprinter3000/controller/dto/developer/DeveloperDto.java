package com.codecool.supersprinter3000.controller.dto.developer;


import com.codecool.supersprinter3000.controller.dto.userstory.UserStoryDto;

import java.util.List;
import java.util.UUID;

public record DeveloperDto(
        UUID id,
        String firstName,
        String lastName,
        String email,
        List<UserStoryDto> userStories
) {
}
