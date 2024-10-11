package com.example.start_upp_rest_api.validation.client;

public class PhoneNumberValidation {
    protected static boolean isCorrectPhoneNumber(String phoneNumber) {
        return !(phoneNumber == null || phoneNumber.trim().isEmpty());
    }
}
