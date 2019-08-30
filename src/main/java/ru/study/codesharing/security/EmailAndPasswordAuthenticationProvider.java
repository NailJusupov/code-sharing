package ru.study.codesharing.security;

import com.sun.security.auth.UserPrincipal;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.study.codesharing.models.domain.UsersDAO;
import ru.study.codesharing.repositories.UsersRepository;

@Component
public class EmailAndPasswordAuthenticationProvider implements AuthenticationProvider {

    private UsersRepository usersRepository;
    private PasswordEncoder passwordEncoder;

    public EmailAndPasswordAuthenticationProvider(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        UsersDAO usersDAO = usersRepository.findByEmail(email);

        if(usersDAO != null && passwordEncoder.matches(password, usersDAO.getPassword())) {
            Object principal = new UserPrincipal(usersDAO.getEmail());

            return new UsernamePasswordAuthenticationToken(principal, password);
        } else {
            throw new BadCredentialsException("External system authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }
}
