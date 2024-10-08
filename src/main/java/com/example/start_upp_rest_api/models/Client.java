package com.example.start_upp_rest_api.models;

public class Client {

    private static final String SEPARATION_SIGN = ",";
    private static final int NAME_INDEX = 0;
    private static final int PHONE_NUMBER_INDEX = 1;
    private String name;
    private String phoneNumber;

    public Client() {
    }

    public Client(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + SEPARATION_SIGN + phoneNumber;
    }

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
