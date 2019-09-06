package ru.study.codesharing.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.study.codesharing.models.domain.FilesDAO;

public interface FilesRepository extends CrudRepository<FilesDAO, Long> {

    Long deleteAllByGistId(long gistId);
}
