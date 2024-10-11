package com.example.start_upp_rest_api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    private static final String SEPARATION_SIGN = ",";
    private String name;
    private String phoneNumber;

    @Override
    public String toString() {
        return name + SEPARATION_SIGN + phoneNumber;
    }
}
