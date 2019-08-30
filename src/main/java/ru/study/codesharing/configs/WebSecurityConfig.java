package ru.study.codesharing.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.study.codesharing.repositories.UsersRepository;
import ru.study.codesharing.security.EmailAndPasswordAuthenticationProvider;
import ru.study.codesharing.security.NonRedirectingAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private NonRedirectingAuthenticationSuccessHandler nonRedirectingAuthenticationSuccessHandler;

    public WebSecurityConfig(NonRedirectingAuthenticationSuccessHandler nonRedirectingAuthenticationSuccessHandler) {
        this.nonRedirectingAuthenticationSuccessHandler = nonRedirectingAuthenticationSuccessHandler;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider(UsersRepository usersRepository, PasswordEncoder passwordEncoder) {
        return new EmailAndPasswordAuthenticationProvider(usersRepository, passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/auth/login").permitAll()
                .antMatchers("/api/auth/userInfo").authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/api/auth/login")
                .successHandler(nonRedirectingAuthenticationSuccessHandler)
                .failureHandler((httpServletRequest, httpServletResponse, e) -> {
                    httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "error here");
                })
                .and()
                .logout()
                .logoutUrl("/api/auth/logout")
                .logoutSuccessHandler(((request, response, authentication) -> response.setStatus(HttpServletResponse.SC_OK)))
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, e) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED)
                )
                .and()
                .csrf().disable();
    }

}
