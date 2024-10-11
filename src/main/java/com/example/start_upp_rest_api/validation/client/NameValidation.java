package com.example.start_upp_rest_api.validation.client;

public class NameValidation {
    public static boolean isCorrectName(String name) {
        return !(name == null || name.trim().isEmpty());
    }
}
