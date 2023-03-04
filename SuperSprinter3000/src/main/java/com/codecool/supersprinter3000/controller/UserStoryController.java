package com.codecool.supersprinter3000.controller;

import com.codecool.supersprinter3000.entity.UserStory;
import com.codecool.supersprinter3000.entity.UserStoryStatus;
import com.codecool.supersprinter3000.service.UserStoryService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class UserStoryController {

    private final UserStoryService userStoryService;

//    @Autowired
    public UserStoryController(UserStoryService userStoryService) {
        this.userStoryService = userStoryService;
    }

    @GetMapping("/")
    public String allUserStories(Model model) {
        model.addAttribute("userStories", userStoryService.getAllUserStories());
        return "index";
    }

    @GetMapping("/new-user-story")
    public String newUserStoryPage(UserStory userStory) {
        return "new_user_story";
    }

    @GetMapping("/story/{id}")
    public String userStoryPage(@PathVariable Long id, Model model) {
        UserStory userStory = userStoryService.getUserStory(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Post not found"));

        model.addAttribute("userStory", userStory);
        return "new_user_story";
    }

    @PostMapping("/new-user-story")
    public String createOrUpdateUserStory(@Valid UserStory userStory, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new_user_story";
        }
        userStoryService.createOrUpdateUserStory(userStory);
        return "redirect:/";
    }

    @ModelAttribute("dropDownAllStatuses")
    private List<String> getUserStoriesStatuses() {
        return Arrays.stream(UserStoryStatus.values())
                .map(Enum::name)
                .toList();
    }
}
