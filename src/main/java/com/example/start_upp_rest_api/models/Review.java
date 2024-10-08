package com.example.start_upp_rest_api.models;

public class Review {

    private static final String SEPARATION_SIGN = ",";
    private static final int RATING_INDEX = 0;
    private static final int PHONE_NUMBER_INDEX = 1;
    private static final int MESSAGE_INDEX = 2;
    private int rating;
    private String phoneNumber;
    private String message;

    public Review() {
    }

    public Review(int rating, String phoneNumber, String message) {
        this.rating = rating;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return rating + SEPARATION_SIGN + phoneNumber + SEPARATION_SIGN + message;
    }

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
