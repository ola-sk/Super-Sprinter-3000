package com.codecool.supersprinter3000.controller.dto.userstory;

import com.codecool.supersprinter3000.entity.UserStoryStatus;

public record NewUserStoryDto(
        String title,
        String description,
        String acceptanceCriteria,
        Double estimation,
        Integer businessValue,
        UserStoryStatus status
) {
}
