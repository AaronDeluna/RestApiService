package com.example.start_upp_rest_api.util.parser;

import com.example.start_upp_rest_api.models.Review;

public class ReviewParseUtils {

    private static final String SEPARATION_SIGN = ",";
    private static final int RATING_INDEX = 0;
    private static final int PHONE_NUMBER_INDEX = 1;
    private static final int MESSAGE_INDEX = 2;

    /**
     * Парсит строку и создает объект {@link Review}.
     *
     * @param line строка с данными отзыва, разделёнными символом {@link #SEPARATION_SIGN}.
     * @return объект {@link Review}, созданный на основе строки.
     * @throws NumberFormatException если рейтинг не является допустимым целым числом.
     */
    public static Review parseString(String line) {
        String[] items = line.split(SEPARATION_SIGN);
        return new Review(
                Integer.parseInt(items[RATING_INDEX]),
                items[PHONE_NUMBER_INDEX],
                items[MESSAGE_INDEX]
        );
    }
}
