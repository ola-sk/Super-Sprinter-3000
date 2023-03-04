package com.codecool.supersprinter3000.service;

import com.codecool.supersprinter3000.entity.UserStory;
import com.codecool.supersprinter3000.repository.UserStoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserStoryService {

    private final UserStoryRepository userStoryRepository;

    public UserStoryService(UserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    public List<UserStory> getAllUserStories() {
        return userStoryRepository.findAllByOrderById();
    }

    public Optional<UserStory> getUserStory(Long id) {
        return userStoryRepository.findById(id);
    }

    public void createOrUpdateUserStory(UserStory userStory) {
        userStoryRepository.save(userStory);
    }
}
