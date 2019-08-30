package ru.study.codesharing.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.study.codesharing.models.domain.UsersDAO;

public interface UsersRepository extends CrudRepository<UsersDAO, Long> {

    UsersDAO findByEmail(String email);
}
