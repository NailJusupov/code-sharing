package ru.study.codesharing.services;

import ru.study.codesharing.models.domain.UsersDAO;

public interface UserService {

    UsersDAO save(UsersDAO userFormData);
}
