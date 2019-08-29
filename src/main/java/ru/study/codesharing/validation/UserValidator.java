package ru.study.codesharing.validation;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ru.study.codesharing.models.domain.UsersDAO;
import ru.study.codesharing.repositories.UsersRepository;

@Component
public class UserValidator implements Validator {

    private final UsersRepository usersRepository;

    public UserValidator(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {
        UsersDAO user = (UsersDAO) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.required");
        if(usersRepository.findAllByEmail(user.getEmail()) != null) {
            errors.rejectValue("email", null, "User with this email already exists");
        }

        if(!user.getEmail().matches("\\w+@\\w+.\\w+")){
            errors.rejectValue("email", "email.incorrect", "Incorrect email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        if(user.getPassword().length() < 6) {
            errors.rejectValue("password", "password.incorrect", "Incorrect password");
        }
    }
}
