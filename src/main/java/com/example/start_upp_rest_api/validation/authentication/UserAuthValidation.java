package com.example.start_upp_rest_api.validation.authentication;

import com.example.start_upp_rest_api.models.User;

import java.io.BufferedReader;
import java.io.FileReader;

public class UserAuthValidation {
    private static final int LOGIN_INDEX = 0;
    private static final int PASSWORD_INDEX = 1;
    public static boolean validation(String fileName, User user) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(",");
                if (items[LOGIN_INDEX].equals(user.getLogin()) || items[PASSWORD_INDEX].equals(user.getPassword())) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        return false;
    }
}
