package com.example.start_upp_rest_api.util;

import java.io.BufferedReader;
import java.io.FileReader;

public class LoginUtils {

    private static final int LOGIN_INDEX = 0;

    /**
     * Проверяет корректность ввода логина.
     *
     * @param fileName имя файла с данными пользователей для проверки существования логина
     * @param login логин, который нужно проверить
     * @return true, если логин корректен (не пустой и не существует в файле), иначе false
     */
    public static boolean isCorrectLoginInput(String fileName, String login) {
        return !login.trim().isEmpty() || isLoginExists(fileName, login);
    }

    /**
     * Проверяет, существует ли указанный логин в файле.
     *
     * @param fileName имя файла с данными пользователей
     * @param login логин, который нужно проверить
     * @return true, если логин уже существует, иначе false
     */
    private static boolean isLoginExists(String fileName, String login) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
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
