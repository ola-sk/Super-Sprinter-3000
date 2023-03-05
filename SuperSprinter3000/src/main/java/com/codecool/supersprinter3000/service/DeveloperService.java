package com.codecool.supersprinter3000.service;

import com.codecool.supersprinter3000.controller.dto.developer.DeveloperDto;
import com.codecool.supersprinter3000.controller.dto.developer.NewDeveloperDto;
import com.codecool.supersprinter3000.entity.Developer;
import com.codecool.supersprinter3000.mapper.DeveloperMapper;
import com.codecool.supersprinter3000.repository.DeveloperRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class DeveloperService {
    private final DeveloperRepository developerRepository;
    private final DeveloperMapper developerMapper;

    public DeveloperService(DeveloperRepository developerRepository, DeveloperMapper developerMapper) {
        this.developerRepository = developerRepository;
        this.developerMapper = developerMapper;
    }

    public List<DeveloperDto> getDevelopers() {
        return developerRepository.findAllBy().stream()
                .map(developerMapper::mapEntityToDeveloperDto)
                .toList();
    }

    public DeveloperDto getDeveloperById(UUID id) {
        return developerRepository.findById(id)
                .map(developerMapper::mapEntityToDeveloperDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public DeveloperDto createDeveloper(NewDeveloperDto developer) {
        Developer entity = developerMapper.mapNewDeveloperDtoToEntity(developer);
        Developer savedEntity = developerRepository.save(entity);
        return developerMapper.mapEntityToDeveloperDto(savedEntity);
    }
}
