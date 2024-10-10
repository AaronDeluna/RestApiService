package com.example.start_upp_rest_api.service;

import com.example.start_upp_rest_api.exception.UserNotFoundException;
import com.example.start_upp_rest_api.models.User;
import com.example.start_upp_rest_api.validation.authentication.UserAuthValidation;
import org.springframework.stereotype.Service;

@Service
public class UserAuthorizationService {

    private static final String FILE_NAME = "user.txt";

    public boolean authorization(User user) throws UserNotFoundException {
        if (!UserAuthValidation.validation(FILE_NAME, user)) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return true;
    }
}
