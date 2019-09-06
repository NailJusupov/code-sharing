package ru.study.codesharing.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.study.codesharing.models.domain.GistsDAO;
import ru.study.codesharing.models.domain.StarsDAO;
import ru.study.codesharing.models.domain.UsersDAO;

public interface StarsRepository extends CrudRepository<StarsDAO, Long> {

    StarsDAO findByUserAndAndGist(UsersDAO usersDAO, GistsDAO gistsDAO);

    int countAllByGistId(long gistId);
}
