package com.example.start_upp_rest_api.validation.authentication;

import com.example.start_upp_rest_api.exception.UserRegistrationException;
import com.example.start_upp_rest_api.models.User;
import com.example.start_upp_rest_api.util.LoginUtils;
import com.example.start_upp_rest_api.util.PasswordUtils;

public class UserRegistrationValidation {

    /**
     * Проверяет данные пользователя при регистрации.
     *
     * @param fileName имя файла с данными для проверки логина
     * @param user объект пользователя с логином и паролем
     * @return возвращает объект пользователя, если проверка пройдена
     * @throws UserRegistrationException если логин пуст, null, уже существует, или если пароль пуст или null
     */
    public static User validation(String fileName, User user) throws UserRegistrationException {
        if (LoginUtils.isCorrectLoginInput(fileName, user.getLogin())) {
            throw new UserRegistrationException("Произошла ошибка при вводе логина!");
        }
        if (PasswordUtils.isCorrectPasswordInput(user.getPassword())) {
            throw new UserRegistrationException("Призошла ошибка при вводе пароля!");
        }
        return user;
    }
}
