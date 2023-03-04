package com.codecool.supersprinter3000.mapper;

import com.codecool.supersprinter3000.controller.dto.developer.DeveloperDto;
import com.codecool.supersprinter3000.controller.dto.developer.NewDeveloperDto;
import com.codecool.supersprinter3000.entity.Developer;
import org.springframework.stereotype.Component;

@Component
public class DeveloperMapper {

    public DeveloperDto mapDeveloperEntityToDto(Developer entity) {
        return new DeveloperDto(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail()
        );
    }


    public Developer mapDeveloperDtoToEntity(NewDeveloperDto newDeveloper) {
        return new Developer(
                newDeveloper.firstName(),
                newDeveloper.lastName(),
                newDeveloper.email()
        );
    }

}
