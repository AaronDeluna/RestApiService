package com.example.start_upp_rest_api.validation.data;

public class PasswordUtils {

    /**
     * Проверяет корректность ввода пароля.
     *
     * @param password пароль, который нужно проверить
     * @return true, если пароль не пустой, иначе false
     */
    public static boolean isCorrectPasswordInput(String password) {
        return !password.trim().isEmpty();
    }
}
