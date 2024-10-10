package com.example.start_upp_rest_api.service;

import com.example.start_upp_rest_api.exception.InvalidClientDataException;
import com.example.start_upp_rest_api.models.Client;
import com.example.start_upp_rest_api.util.FileWriterUtils;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private static final String CLIENT_FILE_NAME = "clients.txt";

    public void addClient(Client client) throws InvalidClientDataException {
        FileWriterUtils.writeToFile(CLIENT_FILE_NAME, validClientData(client));
    }

    /**
     * Проверка клиента который добавляется через форму
     * @param client
     * @return
     * @throws InvalidClientDataException
     */
    private Client validClientData(Client client) throws InvalidClientDataException {
        if (client.getName() == null || client.getName().isEmpty()){
            throw new InvalidClientDataException("Ошибка: имя клинета не может быть пустым");
        }
        if (client.getPhoneNumber() == null || client.getPhoneNumber().isEmpty()) {
            throw new InvalidClientDataException("Ошибка: не корректный ввод номера телефона");
        }
        return client;
    }
}
