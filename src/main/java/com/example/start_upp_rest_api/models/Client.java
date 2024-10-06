package com.example.start_upp_rest_api.models;

public class Client {
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
        return name + "," + phoneNumber;
    }

    public static Client fromString(String line) {
        String[] parts = line.split(",");
        return new Client(parts[0], parts[1]);
    }
}
