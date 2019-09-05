package ru.study.codesharing.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
