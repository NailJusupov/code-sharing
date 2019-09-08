package ru.study.codesharing.services;

import ru.study.codesharing.models.dto.FilesDTO;
import ru.study.codesharing.models.dto.GistsDTO;
import ru.study.codesharing.models.dto.GistsWithStarsDTO;

import java.security.Principal;
import java.util.List;

public interface GistService {

    boolean createGist(GistsDTO gistsDTO, Principal principal);

    boolean addFiles(List<FilesDTO> files, Long gistId);

    List<GistsWithStarsDTO> getAndSortAllGists(String sortBy, int pageNumber);

    long getGistsCount();

    GistsWithStarsDTO getGistById(long gistId);

    boolean deleteGistById(long gistId);

    List<GistsDTO> getGistByTitle(String gistTitle);

}
