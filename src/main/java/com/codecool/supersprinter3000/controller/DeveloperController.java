package com.codecool.supersprinter3000.controller;

import com.codecool.supersprinter3000.controller.dto.developer.DeveloperDto;
import com.codecool.supersprinter3000.controller.dto.developer.NewDeveloperDto;
import com.codecool.supersprinter3000.service.DeveloperService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<DeveloperDto> getAllDevelopers() {
        return developerService.getDevelopers();
    }

    @GetMapping(params = {"page", "size", "sort"})
    public List<DeveloperDto> getAllDevelopersWithPageable(Pageable pageable) {
        return developerService.getDevelopers(pageable);
    }

    @GetMapping(params = {"topN"})
    public List<DeveloperDto> getTopNBusyDevelopers(@RequestParam("topN") Long n) {
        return developerService.getTopBusyDevelopers(n);
    }

    @GetMapping("/{id}")
    public DeveloperDto getDeveloperById(@PathVariable UUID id) {
        return developerService.getDeveloperById(id);
    }

    @PostMapping
    public DeveloperDto newDeveloper(@RequestBody NewDeveloperDto developer) {
        return developerService.createDeveloper(developer);
    }

    @DeleteMapping("/{id}")
    public void softDelete(@PathVariable UUID id) {
        developerService.softDelete(id);
    }
}
