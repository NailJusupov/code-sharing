package ru.study.codesharing.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.study.codesharing.models.domain.GistsDAO;

public interface GistsRepository extends CrudRepository<GistsDAO, Long> {

    public GistsDAO getById(Long id);

}
