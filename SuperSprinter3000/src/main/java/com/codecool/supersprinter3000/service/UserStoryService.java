package com.codecool.supersprinter3000.service;

import com.codecool.supersprinter3000.controller.dto.NewUserStoryDto;
import com.codecool.supersprinter3000.controller.dto.UserStoryDto;
import com.codecool.supersprinter3000.entity.UserStory;
import com.codecool.supersprinter3000.mapper.UserStoryMapper;
import com.codecool.supersprinter3000.repository.UserStoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class UserStoryService {

    private final UserStoryRepository userStoryRepository;
    private final UserStoryMapper userStoryMapper;

    public UserStoryService(UserStoryRepository userStoryRepository, UserStoryMapper userStoryMapper) {
        this.userStoryRepository = userStoryRepository;
        this.userStoryMapper = userStoryMapper;
    }

    public List<UserStoryDto> getAllUserStories() {
        return userStoryRepository.findAll().stream()
                .map(userStoryMapper::mapUserStoryEntityToDto)
                .toList();
    }

    public UserStoryDto getUserStory(UUID id) {
        return userStoryRepository.findById(id)
                .map(userStoryMapper::mapUserStoryEntityToDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public UserStoryDto addNewUserStory(NewUserStoryDto newUserStory) {
        UserStory entity = userStoryMapper.mapUserStoryDtoToEntity(newUserStory);
        UserStory savedUserStory = userStoryRepository.save(entity);
        return userStoryMapper.mapUserStoryEntityToDto(savedUserStory);
    }
}
