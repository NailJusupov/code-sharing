package ru.study.codesharing.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.study.codesharing.models.domain.GistsDAO;
import ru.study.codesharing.models.domain.UsersDAO;

import java.util.List;

public interface GistsRepository extends CrudRepository<GistsDAO, Long> {

    GistsDAO getById(Long id);

    Page<GistsDAO> findAll(Pageable pageable);

    @Query("Select gist from GistsDAO gist order by gist.stars.size desc")
    Page<GistsDAO> findAllByStarsCount(Pageable pageable);

    List<GistsDAO> findAllByTitleContains(String gistTitle);

    @Query(
            value = "SELECT DISTINCT gists.* FROM gists " +
                    "LEFT JOIN stars ON gists.id = stars.gist_id " +
                    "WHERE stars.user_id = ?1",
            nativeQuery = true
    )
    Page<GistsDAO> findAllByUserFavourites(long userId, Pageable pageable);

    @Query(
            value = "SELECT COUNT(gists.id) FROM gists " +
                    "LEFT JOIN stars ON gists.id = stars.gist_id " +
                    "WHERE stars.user_id = ?1",
            nativeQuery = true
    )
    long countAllByUserFavourites(long userId);

    Page<GistsDAO> findAllByUser(UsersDAO user, Pageable pageable);

    long countAllByUser(UsersDAO user);

}
