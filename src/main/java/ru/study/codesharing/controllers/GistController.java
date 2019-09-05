package ru.study.codesharing.controllers;

import org.springframework.web.bind.annotation.*;
import ru.study.codesharing.models.dto.GistsDTO;
import ru.study.codesharing.models.dto.GistsWithStarsDTO;
import ru.study.codesharing.services.GistService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/gists")
public class GistController {

    private GistService gistService;

    public GistController(GistService gistService) {
        this.gistService = gistService;
    }

    @PostMapping("/add-gist")
    public boolean createGist(@RequestBody GistsDTO gistsDTO, Principal principal) {
        return gistService.createGist(gistsDTO, principal);
    }

    @GetMapping("/get-all-gists")
    public List<GistsWithStarsDTO> getAllGists(@RequestParam(name = "sortBy", defaultValue = "creationDate") String sortBy,
                                               @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {
        return gistService.getAndSortAllGists(sortBy, pageNumber);
    }
}
