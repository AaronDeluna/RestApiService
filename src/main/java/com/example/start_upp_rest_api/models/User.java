package com.example.start_upp_rest_api.models;

public class User {
    private static final String SEPARATION_SIGN = ",";
    private static final int LOGIN_INDEX = 0;
    private static final int PASSWORD_INDEX = 1;
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
        return login + SEPARATION_SIGN + password;
    }

    /**
     * Парсит строку для создания объекта пользователя.
     *
     * @param line строка, содержащая данные пользователя
     * @return объект User, созданный из данных в строке
     */
    public static User parseUser(String line) {
        String[] items = line.split(SEPARATION_SIGN);
        return new User(items[LOGIN_INDEX], items[PASSWORD_INDEX]);
    }
}
