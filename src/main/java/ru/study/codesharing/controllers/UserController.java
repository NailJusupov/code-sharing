package ru.study.codesharing.controllers;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.study.codesharing.models.domain.UsersDAO;
import ru.study.codesharing.services.UserService;
import ru.study.codesharing.validation.UserValidator;

import java.security.Principal;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserValidator userValidator;
    private final UserService userService;

    public UserController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UsersDAO userFormData, BindingResult bindingResult) {
        userValidator.validate(userFormData, bindingResult);

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.OK);
        }

        userService.save(userFormData);

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/userInfo")
    public String getAuthUserInfo(Principal principal) {
        return JSONObject.quote( principal.getName());
    }


}
