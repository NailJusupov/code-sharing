package ru.study.codesharing.services.Impl;

import org.springframework.stereotype.Service;
import ru.study.codesharing.models.domain.GistsDAO;
import ru.study.codesharing.models.domain.StarCompositeId;
import ru.study.codesharing.models.domain.StarsDAO;
import ru.study.codesharing.models.domain.UsersDAO;
import ru.study.codesharing.repositories.GistsRepository;
import ru.study.codesharing.repositories.StarsRepository;
import ru.study.codesharing.repositories.UsersRepository;
import ru.study.codesharing.services.StarsService;

import java.security.Principal;

@Service
public class StarsServiceImpl implements StarsService {

    private UsersRepository usersRepository;
    private GistsRepository gistsRepository;
    private StarsRepository starsRepository;

    public StarsServiceImpl(UsersRepository usersRepository,
                            GistsRepository gistsRepository,
                            StarsRepository starsRepository) {
        this.usersRepository = usersRepository;
        this.gistsRepository = gistsRepository;
        this.starsRepository = starsRepository;
    }

    public boolean setStarToGist(long gistId, Principal principal) {

        UsersDAO user = usersRepository.findByEmail(principal.getName());
        GistsDAO gist = gistsRepository.getById(gistId);

        StarsDAO star = starsRepository.findByUserAndAndGist(user, gist);

        if(star != null) {
            return false;
        }

        StarsDAO starsDAO = new StarsDAO();

        starsDAO.setId(new StarCompositeId(user.getId(), gist.getId()));
        starsDAO.setGist(gist);
        starsDAO.setUser(user);

        starsRepository.save(starsDAO);

        return true;

    }

}
