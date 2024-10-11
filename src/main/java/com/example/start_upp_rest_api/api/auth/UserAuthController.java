package com.example.start_upp_rest_api.api.auth;

import com.example.start_upp_rest_api.exception.UserNotFoundException;
import com.example.start_upp_rest_api.exception.UserRegistrationException;
import com.example.start_upp_rest_api.models.User;
import com.example.start_upp_rest_api.service.UserAuthorizationService;
import com.example.start_upp_rest_api.service.UserRegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth/")
@AllArgsConstructor
public class UserAuthController {

    private final UserRegistrationService userRegistrationService;
    private final UserAuthorizationService userAuthorizationService;

    @PostMapping("register")
    public ResponseEntity<String> registrationUser(@RequestBody User user) {
        try {
            userRegistrationService.registration(user);
            return new ResponseEntity<>("Пользователь успешно зарегестрирован", HttpStatus.CREATED);
        } catch (UserRegistrationException e) {
            return new ResponseEntity<>("Ошибка: " + e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("login")
    public ResponseEntity<String> authorization(@RequestBody User user) {
        try {
            userAuthorizationService.authorization(user);
            return new ResponseEntity<>("Пользователь есть!", HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("Ошибка: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
