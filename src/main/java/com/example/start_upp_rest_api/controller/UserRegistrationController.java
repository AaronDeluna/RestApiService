package com.example.start_upp_rest_api.controller;

import com.example.start_upp_rest_api.exception.UserRegistrationException;
import com.example.start_upp_rest_api.models.User;
import com.example.start_upp_rest_api.service.UserRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user/registration")
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    public ResponseEntity<String> registrationUser(@RequestBody User user) {
        try {
            userRegistrationService.register(user);
            return new ResponseEntity<>("Пользователь успешно зарегестрирован", HttpStatus.CREATED);
        } catch (UserRegistrationException e) {
            return new ResponseEntity<>("Ошибка: " + e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
