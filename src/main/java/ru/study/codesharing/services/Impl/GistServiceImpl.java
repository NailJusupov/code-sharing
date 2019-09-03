package ru.study.codesharing.services.Impl;

import org.springframework.stereotype.Service;
import ru.study.codesharing.models.domain.FilesDAO;
import ru.study.codesharing.models.domain.GistsDAO;
import ru.study.codesharing.models.domain.UsersDAO;
import ru.study.codesharing.models.dto.FilesDTO;
import ru.study.codesharing.models.dto.GistsDTO;
import ru.study.codesharing.repositories.FilesRepository;
import ru.study.codesharing.repositories.GistsRepository;
import ru.study.codesharing.repositories.UsersRepository;
import ru.study.codesharing.services.GistService;

import java.security.Principal;
import java.util.Date;
import java.util.List;

@Service
public class GistServiceImpl implements GistService {

    private GistsRepository gistsRepository;
    private UsersRepository usersRepository;
    private FilesRepository filesRepository;

    public GistServiceImpl(GistsRepository gistsRepository,
                           UsersRepository usersRepository,
                           FilesRepository filesRepository) {
        this.gistsRepository = gistsRepository;
        this.usersRepository = usersRepository;
        this.filesRepository = filesRepository;
    }

    @Override
    public boolean createGist(GistsDTO gistsDTO, Principal principal) {

        UsersDAO user = usersRepository.findByEmail(principal.getName());

        GistsDAO gist = new GistsDAO();
        gist.setUser(user);
        gist.setTitle(gistsDTO.getTitle());
        gist.setDescription(gistsDTO.getDescription());
        gist.setProgrammingLanguage(gistsDTO.getProgrammingLanguage());
        gist.setCreationDate(new Date());

        gistsRepository.save(gist);

        this.addFiles(gistsDTO.getFiles(), gist.getId());

        return true;
    }

    @Override
    public boolean addFiles(List<FilesDTO> files, Long gistId) {

        for (FilesDTO file:
             files) {
            FilesDAO filesDAO = new FilesDAO();
            filesDAO.setCode(file.getCode());
            filesDAO.setFileName(file.getFileName());
            filesDAO.setGist(gistsRepository.getById(gistId));

            filesRepository.save(filesDAO);
        }

        return true;
    }
}
