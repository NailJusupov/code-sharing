package ru.study.codesharing.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.study.codesharing.models.domain.FilesDAO;

import javax.transaction.Transactional;
import java.util.List;

public interface FilesRepository extends CrudRepository<FilesDAO, Long> {

    @Transactional
    List<FilesDAO> removeAllByGist_Id(long gistId);

}
