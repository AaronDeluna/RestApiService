package com.example.start_upp_rest_api.models;

public class User {
    private String login;
    private String password;
    private UserType userType = UserType.USER;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return login + "," + password;
    }

    public static User parseUser(String line) {
        String[] items = line.split(",");
        return new User(items[0], items[1]);
    }
}
