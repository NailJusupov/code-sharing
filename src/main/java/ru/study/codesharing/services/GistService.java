package ru.study.codesharing.services;

import ru.study.codesharing.models.dto.FilesDTO;
import ru.study.codesharing.models.dto.GistsDTO;

import java.security.Principal;
import java.util.List;

public interface GistService {

    boolean createGist(GistsDTO gistsDTO, Principal principal);

    boolean addFiles(List<FilesDTO> files, Long gistId);
}
