package com.codecool.supersprinter3000.controller.dto.userstory;

import com.codecool.supersprinter3000.controller.dto.IdDisplayNamePairDto;
import com.codecool.supersprinter3000.entity.UserStoryStatus;

import java.util.List;
import java.util.UUID;

public record UserStoryDto(
        UUID id,
        String title,
        String description,
        String acceptanceCriteria,
        Double estimation,
        Integer businessValue,
        UserStoryStatus status,
        List<IdDisplayNamePairDto> assignedDevelopers
) {
}
