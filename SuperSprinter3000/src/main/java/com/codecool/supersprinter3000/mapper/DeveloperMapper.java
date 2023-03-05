package com.codecool.supersprinter3000.mapper;

import com.codecool.supersprinter3000.controller.dto.developer.DeveloperDto;
import com.codecool.supersprinter3000.controller.dto.developer.NewDeveloperDto;
import com.codecool.supersprinter3000.entity.Developer;
import org.springframework.stereotype.Component;

@Component
public class DeveloperMapper {

    private final UserStoryMapper userStoryMapper;

    public DeveloperMapper(UserStoryMapper userStoryMapper) {
        this.userStoryMapper = userStoryMapper;
    }

    public Developer mapNewDeveloperDtoToEntity(NewDeveloperDto dto) {
        return new Developer(dto.firstName(), dto.lastName(), dto.email());
    }

    public DeveloperDto mapEntityToDeveloperDto(Developer entity) {
        return new DeveloperDto(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail(),
                entity.getUserStories().stream()
                        .map(userStoryMapper::mapUserStoryEntityToDto)
                        .toList()
        );
    }
}
