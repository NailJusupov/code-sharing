package ru.study.codesharing.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.study.codesharing.models.domain.GistsDAO;

import java.util.List;

public interface GistsRepository extends CrudRepository<GistsDAO, Long> {

    GistsDAO getById(Long id);

    Page<GistsDAO> findAll(Pageable pageable);

    @Query("Select gist from GistsDAO gist order by gist.stars.size desc")
    Page<GistsDAO> findAllByStarsCount(Pageable pageable);

    List<GistsDAO> findAllByTitleContains(String gistTitle);

}
