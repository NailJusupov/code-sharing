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

    @PutMapping("/update-gist")
    public boolean updateGist(@RequestBody GistsDTO gistsDTO) {
        return gistService.updateGist(gistsDTO);
    }

    @GetMapping("/get-all-gists")
    public List<GistsWithStarsDTO> getAllGists(@RequestParam(name = "sortBy", defaultValue = "creationDate") String sortBy,
                                               @RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber) {

        return gistService.getAndSortAllGists(sortBy, pageNumber);
    }

    @GetMapping("/get-all-gists-by-search-param")
    public List<GistsWithStarsDTO> getAllGistsByParam(@RequestParam(name = "pageNumber", defaultValue = "0") int pageNumber,
                                                      @RequestParam(name = "searchParam", defaultValue = "favourites") String searchParam,
                                                      Principal principal) {

        return gistService.getAndSortAllGistsBySearchParam(pageNumber, searchParam, principal);
    }

    @GetMapping("/get-gists-count")
    public long getGistsCount() {
        return gistService.getAllGistsCount();
    }

    @GetMapping("/get-gist-by-id")
    public GistsWithStarsDTO getGistById(@RequestParam(name = "gistId", required = true) long gistId) {
        return gistService.getGistById(gistId);
    }

    @DeleteMapping("/delete-gist-by-id")
    public boolean deleteGistById(@RequestParam(name = "gistId", required = true) long gistId) {
        return gistService.deleteGistById(gistId);
    }

    @GetMapping("/get-gist-by-title")
    public List<GistsDTO> getGistByTitle(@RequestParam(name = "gistTitle", required = true) String gistTitle) {
        return gistService.getGistByTitle(gistTitle);
    }

    @GetMapping("/get-all-gists-count-by-search-param")
    public long getGistsCountByParam(@RequestParam(name = "searchParam", defaultValue = "favourites") String searchParam,
                                     Principal principal) {
        return gistService.getGistsCountByParam(searchParam, principal);
    }
}
