package com.codecool.supersprinter3000.service;

import com.codecool.supersprinter3000.controller.dto.userstory.NewUserStoryDto;
import com.codecool.supersprinter3000.controller.dto.userstory.UserStoryDto;
import com.codecool.supersprinter3000.entity.Developer;
import com.codecool.supersprinter3000.entity.UserStory;
import com.codecool.supersprinter3000.mapper.UserStoryMapper;
import com.codecool.supersprinter3000.repository.DeveloperRepository;
import com.codecool.supersprinter3000.repository.UserStoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class UserStoryService {

    private final UserStoryRepository userStoryRepository;
    private final DeveloperRepository developerRepository;
    private final UserStoryMapper userStoryMapper;

    public UserStoryService(UserStoryRepository userStoryRepository, DeveloperRepository developerRepository, UserStoryMapper userStoryMapper) {
        this.userStoryRepository = userStoryRepository;
        this.developerRepository = developerRepository;
        this.userStoryMapper = userStoryMapper;
    }

    public List<UserStoryDto> getAllUserStories() {
        return userStoryRepository.findAllBy().stream()
                .map(userStoryMapper::mapUserStoryEntityToDto)
                .toList();
    }

    public UserStoryDto getUserStory(UUID id) {
        return userStoryRepository.findOneById(id)
                .map(userStoryMapper::mapUserStoryEntityToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserStoryDto addNewUserStory(NewUserStoryDto newUserStory) {
        UserStory entity = userStoryMapper.mapUserStoryDtoToEntity(newUserStory);
        UserStory savedUserStory = userStoryRepository.save(entity);
        return userStoryMapper.mapUserStoryEntityToDto(savedUserStory);
    }

    public void assignStoryToDeveloper(UUID userStoryId, UUID developerId) {
        UserStory userStory = userStoryRepository.findById(userStoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        Developer developer = developerRepository.findById(developerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        userStory.assignDeveloper(developer);
        developer.addUserStory(userStory);

        developerRepository.save(developer);
    }


    public List<UserStoryDto> getAllUserStoriesWithoutDeveloper() {
        return userStoryRepository.findAllBy().stream()
                .filter(UserStory::hasNoDeveloperAssigned)
                .map(userStoryMapper::mapUserStoryEntityToDto)
                .toList();
    }
}
