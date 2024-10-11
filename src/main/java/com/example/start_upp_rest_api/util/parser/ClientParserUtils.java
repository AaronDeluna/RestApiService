package com.example.start_upp_rest_api.util.parser;

import com.example.start_upp_rest_api.models.Client;

public class ClientParserUtils {

    private static final String SEPARATION_SIGN = ",";
    private static final int NAME_INDEX = 0;
    private static final int PHONE_NUMBER_INDEX = 1;

    /**
     * Создает объект {@link Client} из строки.
     *
     * @param line строка с данными клиента, разделёнными символом {@link #SEPARATION_SIGN}.
     * @return объект {@link Client}, созданный на основе строки.
     */
    public static Client fromString(String line) {
        String[] parts = line.split(SEPARATION_SIGN);
        return new Client(parts[NAME_INDEX], parts[PHONE_NUMBER_INDEX]);
    }
}
