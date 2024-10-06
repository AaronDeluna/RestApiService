package com.example.start_upp_rest_api.service;

import com.example.start_upp_rest_api.exception.InvalidClientDataException;
import com.example.start_upp_rest_api.models.Client;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {
    private static final String FILE_NAME = "clients.txt";

    public void addClient(Client client) throws InvalidClientDataException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(validClientData(client).toString());
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Client validClientData(Client client) throws InvalidClientDataException {
        if (client.getName().isEmpty() || client.getName() == null){
            throw new InvalidClientDataException("Ошибка: имя клинета не может быть пустым");
        }
        if (client.getPhoneNumber().isEmpty() || client.getPhoneNumber() == null) {
            throw new InvalidClientDataException("Ошибка: не корректный ввод номера телефона");
        }
        return client;
    }

    public List<Client> getAllClients() {
        List<Client> clientList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                clientList.add(Client.fromString(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return clientList;
    }
}
