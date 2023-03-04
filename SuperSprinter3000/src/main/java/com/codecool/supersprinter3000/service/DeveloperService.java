package com.codecool.supersprinter3000.service;

import com.codecool.supersprinter3000.controller.dto.developer.DeveloperDto;
import com.codecool.supersprinter3000.controller.dto.developer.NewDeveloperDto;
import com.codecool.supersprinter3000.entity.Developer;
import com.codecool.supersprinter3000.mapper.DeveloperMapper;
import com.codecool.supersprinter3000.repository.DeveloperRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class DeveloperService {
    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;


    public List<DeveloperDto> getAllDevelopers() {
        return developerRepository.findAll().stream()
                .map(developerMapper::mapDeveloperEntityToDto)
                .toList();
    }

    public DeveloperDto getDeveloper(UUID id) {
        return developerRepository.findById(id)
                .map(developerMapper::mapDeveloperEntityToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public DeveloperDto addNewDeveloper(NewDeveloperDto newDeveloper) {
        Developer developer = developerMapper.mapDeveloperDtoToEntity(newDeveloper);
        Developer dbDeveloper = developerRepository.save(developer);
        return developerMapper.mapDeveloperEntityToDto(dbDeveloper);
    }
}
