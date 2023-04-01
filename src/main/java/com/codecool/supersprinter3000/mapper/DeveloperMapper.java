package com.codecool.supersprinter3000.mapper;

import com.codecool.supersprinter3000.controller.dto.IdDisplayNamePairDto;
import com.codecool.supersprinter3000.controller.dto.developer.DeveloperDto;
import com.codecool.supersprinter3000.controller.dto.developer.NewDeveloperDto;
import com.codecool.supersprinter3000.entity.Developer;
import com.codecool.supersprinter3000.entity.UserStory;
import org.springframework.stereotype.Component;

@Component
public class DeveloperMapper {

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
                        .map(this::getIdDisplayNamePair)
                        .toList()
        );
    }

    private IdDisplayNamePairDto getIdDisplayNamePair(UserStory us) {
        return new IdDisplayNamePairDto(us.getId(), us.getTitle());
    }
}
