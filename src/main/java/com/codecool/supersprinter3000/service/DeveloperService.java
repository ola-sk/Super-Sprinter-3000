package com.codecool.supersprinter3000.service;

import com.codecool.supersprinter3000.controller.dto.developer.DeveloperDto;
import com.codecool.supersprinter3000.controller.dto.developer.NewDeveloperDto;
import com.codecool.supersprinter3000.entity.Developer;
import com.codecool.supersprinter3000.mapper.DeveloperMapper;
import com.codecool.supersprinter3000.repository.DeveloperRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
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

    public List<DeveloperDto> getDevelopers(Pageable pageable) {
        return developerRepository.findAllBy(pageable).stream()
                .map(developerMapper::mapEntityToDeveloperDto)
                .toList();
    }

    public DeveloperDto getDeveloperById(UUID id) {
        return developerRepository.findOneById(id)
                .map(developerMapper::mapEntityToDeveloperDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public DeveloperDto createDeveloper(NewDeveloperDto developer) {
        Developer entity = developerMapper.mapNewDeveloperDtoToEntity(developer);
        Developer savedEntity = developerRepository.save(entity);
        return developerMapper.mapEntityToDeveloperDto(savedEntity);
    }

    public List<DeveloperDto> getTopBusyDevelopers(Long n) {
        return developerRepository.findAllBy().stream()
                .sorted(Comparator.comparingInt(Developer::getUserStoriesCount).reversed())
                .limit(n)
                .map(developerMapper::mapEntityToDeveloperDto)
                .toList();
    }

    public void softDelete(UUID id) {
        Developer developer = developerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        obfuscateSensitiveData(developer);
        developerRepository.save(developer);
    }

    private void obfuscateSensitiveData(Developer developer) {
        int firstNameLength = developer.getFirstName().length();
        developer.setFirstName("*".repeat(firstNameLength));

        int lastNameLength = developer.getLastName().length();
        developer.setLastName("*".repeat(lastNameLength));

        int atCharPos = developer.getEmail().indexOf('@');
        String randomPrefix = "deleted-" + UUID.randomUUID();
        developer.setEmail(randomPrefix + developer.getEmail().substring(atCharPos));

        developer.clearAllUserStories();
    }
}
