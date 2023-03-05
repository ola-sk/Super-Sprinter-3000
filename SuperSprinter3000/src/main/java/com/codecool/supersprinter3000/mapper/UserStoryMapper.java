package com.codecool.supersprinter3000.mapper;

import com.codecool.supersprinter3000.controller.dto.userstory.NewUserStoryDto;
import com.codecool.supersprinter3000.controller.dto.userstory.UserStoryDto;
import com.codecool.supersprinter3000.entity.UserStory;
import org.springframework.stereotype.Component;

@Component
public class UserStoryMapper {
    public UserStoryDto mapUserStoryEntityToDto(UserStory entity) {
        return new UserStoryDto(
                entity.getId(),
                entity.getTitle(),
                entity.getStory(),
                entity.getAcceptanceCriteria(),
                entity.getEstimation(),
                entity.getBusinessValue(),
                entity.getUserStoryStatus()
        );
    }

    public UserStory mapUserStoryDtoToEntity(NewUserStoryDto dto) {
        return new UserStory(
                dto.title(),
                dto.description(),
                dto.acceptanceCriteria(),
                dto.estimation(),
                dto.businessValue(),
                dto.status()
        );
    }
}
