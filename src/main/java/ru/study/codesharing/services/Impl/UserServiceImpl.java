package ru.study.codesharing.services.Impl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.study.codesharing.models.domain.UsersDAO;
import ru.study.codesharing.repositories.UsersRepository;
import ru.study.codesharing.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UsersDAO save(UsersDAO userFormData) {
        UsersDAO usersDAO = new UsersDAO();
        String encodedPassword = passwordEncoder.encode(userFormData.getPassword());

        usersDAO.setEmail(userFormData.getEmail());
        usersDAO.setName(userFormData.getName());
        usersDAO.setPassword(encodedPassword);

        return usersRepository.save(usersDAO);
    }

    public UsersDAO getAllInfoByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
