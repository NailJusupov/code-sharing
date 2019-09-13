package ru.study.codesharing.controllers;

import org.springframework.web.bind.annotation.*;
import ru.study.codesharing.services.StarsService;

import java.security.Principal;

@RestController
@RequestMapping("/api/stars")
public class StarsController {

    private StarsService starsService;

    public StarsController(StarsService starsService) {
        this.starsService = starsService;
    }

    @PostMapping("/set-star-to-gist")
    public boolean setStarToGist(@RequestBody long gistId, Principal principal) {
        return starsService.setStarToGist(gistId, principal);
    }
}
