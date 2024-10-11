package com.example.start_upp_rest_api.controller;

import com.example.start_upp_rest_api.exception.UserNotFoundException;
import com.example.start_upp_rest_api.models.User;
import com.example.start_upp_rest_api.service.UserAuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/authorization")
public class UserAuthorizationController {

    private final UserAuthorizationService userAuthorizationService;

    public UserAuthorizationController(UserAuthorizationService userAuthorizationService) {
        this.userAuthorizationService = userAuthorizationService;
    }

    @GetMapping
    public ResponseEntity<String> authorization(@RequestBody User user) {
        try {
            userAuthorizationService.authorization(user);
            return new ResponseEntity<>("Пользователь есть!", HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("Ошибка: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
