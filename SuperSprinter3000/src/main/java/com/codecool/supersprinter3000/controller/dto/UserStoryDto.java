package com.codecool.supersprinter3000.controller.dto;

import com.codecool.supersprinter3000.entity.UserStoryStatus;

public record UserStoryDto(
        Long id,
        String title,
        String description,
        String acceptanceCriteria,
        Double estimation,
        Integer businessValue,
        UserStoryStatus status
) {
}
