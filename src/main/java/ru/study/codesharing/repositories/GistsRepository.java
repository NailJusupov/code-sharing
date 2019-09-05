package ru.study.codesharing.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.study.codesharing.models.domain.GistsDAO;

public interface GistsRepository extends CrudRepository<GistsDAO, Long> {

    GistsDAO getById(Long id);

    Page<GistsDAO> findAll(Pageable pageable);

}
