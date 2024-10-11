package com.example.start_upp_rest_api.models;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
public class User {
    private static final String SEPARATION_SIGN = ",";
    private final String login;
    private final String password;
    private UserType userType = UserType.USER;

    @Override
    public String toString() {
        return login + SEPARATION_SIGN + password;
    }

}
