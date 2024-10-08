package com.example.start_upp_rest_api.service;

import com.example.start_upp_rest_api.exception.UserRegistrationException;
import com.example.start_upp_rest_api.models.User;
import com.example.start_upp_rest_api.util.FileWriterUtil;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;

@Service
public class UserRegistrationService {

    private static final int LOGIN_INDEX = 0;
    private static final int PASSWORD_INDEX = 1;

    private static final String FILE_NAME = "user.txt";

    public void register(User user) throws UserRegistrationException {
        FileWriterUtil.writeToFile(FILE_NAME, validUserData(user).toString());
    }

    /**
     * Валидирует данные пользователя.
     *
     * @param user объект User.
     * @return объект User.
     * @throws UserRegistrationException если логин пуст или пароль некорректен.
     */
    private User validUserData(User user) throws UserRegistrationException {
        if (user.getLogin().isEmpty()
                || user.getLogin() == null
                || validationUserData(user.getLogin())) {
            throw new UserRegistrationException("Произошла ошибка при вводе логина");
        }

        if (user.getPassword().isEmpty() || user.getPassword() == null) {
            throw new UserRegistrationException("Призошла ошибка при вводе пароля");
        }
        return user;
    }

    /**
     * Проверяет, соответствует ли пароль данным из файла.
     *
     * @return true, если пароль найден в файле, иначе false.
     */
    private boolean validationUserData(String login) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");
                if (items[LOGIN_INDEX].equals(login)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return false;
    }
}
