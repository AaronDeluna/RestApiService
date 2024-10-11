package com.example.start_upp_rest_api.util.parser;

import com.example.start_upp_rest_api.models.User;

public class UserParserUtils {

    private static final String SEPARATION_SIGN = ",";
    private static final int LOGIN_INDEX = 0;
    private static final int PASSWORD_INDEX = 1;

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
