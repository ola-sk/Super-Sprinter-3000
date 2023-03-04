package com.codecool.supersprinter3000.controller;


import com.codecool.supersprinter3000.controller.dto.developer.DeveloperDto;
import com.codecool.supersprinter3000.controller.dto.developer.NewDeveloperDto;
import com.codecool.supersprinter3000.service.DeveloperService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }


    @GetMapping
    public List<DeveloperDto> getAllDevelopers() { return developerService.getAllDevelopers(); }

    @GetMapping("/{id}")
    public DeveloperDto getDeveloper(@PathVariable UUID id) { return developerService.getDeveloper(id); }

    @PostMapping
    public DeveloperDto addNewDeveloper(@RequestBody NewDeveloperDto newDeveloper) {
        return developerService.addNewDeveloper(newDeveloper);
    }

}
