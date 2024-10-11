package com.example.start_upp_rest_api.service;

import com.example.start_upp_rest_api.exception.UserRegistrationException;
import com.example.start_upp_rest_api.models.User;
import com.example.start_upp_rest_api.util.file.FileWriterUtils;
import com.example.start_upp_rest_api.validation.authentication.UserRegistrationValidation;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private static final String FILE_NAME = "user.txt";

    /**
     * Регистрирует пользователя, записывая его данные в файл после прохождения валидации.
     *
     * @param user объект пользователя для регистрации
     * @throws UserRegistrationException если данные пользователя не прошли валидацию
     */
    public void registration(User user) throws UserRegistrationException {
        FileWriterUtils.writeToFile(FILE_NAME, UserRegistrationValidation.validation(FILE_NAME, user).toString());
    }
}
