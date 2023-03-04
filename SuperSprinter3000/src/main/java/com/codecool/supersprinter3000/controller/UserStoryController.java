package com.codecool.supersprinter3000.controller;

import com.codecool.supersprinter3000.controller.dto.NewUserStoryDto;
import com.codecool.supersprinter3000.controller.dto.UserStoryDto;
import com.codecool.supersprinter3000.service.UserStoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user-stories")
public class UserStoryController {

    private final UserStoryService userStoryService;

    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @GetMapping
    public List<UserStoryDto> getAllUSerStories() {
        return userStoryService.getAllUserStories();
    }

    @GetMapping("/{id}")
    public UserStoryDto getUserStory(@PathVariable UUID id) {
        return userStoryService.getUserStory(id);
    }

    @PostMapping
    public UserStoryDto createNewUserStory(@RequestBody NewUserStoryDto newUserStory) {
        return userStoryService.addNewUserStory(newUserStory);
    }
}
