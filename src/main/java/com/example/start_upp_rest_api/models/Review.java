package com.example.start_upp_rest_api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

    private static final String SEPARATION_SIGN = ",";
    private int rating;
    private String phoneNumber;
    private String message;

    @Override
    public String toString() {
        return rating + SEPARATION_SIGN + phoneNumber + SEPARATION_SIGN + message;
    }
}
