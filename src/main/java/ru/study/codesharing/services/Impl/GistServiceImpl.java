package ru.study.codesharing.services.Impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.study.codesharing.converters.GistMapper;
import ru.study.codesharing.models.domain.FilesDAO;
import ru.study.codesharing.models.domain.GistsDAO;
import ru.study.codesharing.models.domain.StarsDAO;
import ru.study.codesharing.models.domain.UsersDAO;
import ru.study.codesharing.models.dto.FilesDTO;
import ru.study.codesharing.models.dto.GistsDTO;
import ru.study.codesharing.models.dto.GistsWithStarsDTO;
import ru.study.codesharing.repositories.FilesRepository;
import ru.study.codesharing.repositories.GistsRepository;
import ru.study.codesharing.repositories.StarsRepository;
import ru.study.codesharing.repositories.UsersRepository;
import ru.study.codesharing.services.GistService;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class GistServiceImpl implements GistService {

    private GistsRepository gistsRepository;
    private UsersRepository usersRepository;
    private FilesRepository filesRepository;
    private StarsRepository starsRepository;

    private GistMapper gistMapper = Mappers.getMapper(GistMapper.class);

    private static final int PAGE_SIZE = 6;

    public GistServiceImpl(GistsRepository gistsRepository,
                           UsersRepository usersRepository,
                           FilesRepository filesRepository,
                           StarsRepository starsRepository) {
        this.gistsRepository = gistsRepository;
        this.usersRepository = usersRepository;
        this.filesRepository = filesRepository;
        this.starsRepository = starsRepository;
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

        for (FilesDTO file :
                files) {
            FilesDAO filesDAO = new FilesDAO();
            filesDAO.setCode(file.getCode());
            filesDAO.setFileName(file.getFileName());
            filesDAO.setGist(gistsRepository.getById(gistId));

            filesRepository.save(filesDAO);
        }

        return true;
    }

    @Override
    public List<GistsWithStarsDTO> getAndSortAllGists(String sortBy, int pageNumber) {

        Pageable gistsPage;
        Page<GistsDAO> gistsDAOPage;

        if(sortBy.equals("evaluation")) {
            gistsPage = PageRequest.of(pageNumber, PAGE_SIZE);
            gistsDAOPage = gistsRepository.findAllByStarsCount(gistsPage);
        } else {
            gistsPage = PageRequest.of(pageNumber, PAGE_SIZE, Sort.by(sortBy));
            gistsDAOPage = gistsRepository.findAll(gistsPage);
        }

        List<GistsWithStarsDTO> gists = gistMapper.toGistsListDTO(gistsDAOPage.getContent());

        for (GistsWithStarsDTO gist:
             gists) {
            gist.setStarsCount(starsRepository.countAllByGistId(gist.getId()));
        }

        return gists;
    }

    @Override
    public long getGistsCount() {
        return gistsRepository.count();
    }

    @Override
    public GistsWithStarsDTO getGistById(long gistId) {

        GistsWithStarsDTO gist = gistMapper.toGistWithStars(gistsRepository.getById(gistId));

        gist.setStarsCount(starsRepository.countAllByGistId(gist.getId()));

        return gist;
    }

    @Override
    public boolean deleteGistById(long gistId) {

        try {
            filesRepository.deleteAllByGistId(gistId);
            starsRepository.deleteAllByGistId(gistId);
            gistsRepository.deleteById(gistId);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
