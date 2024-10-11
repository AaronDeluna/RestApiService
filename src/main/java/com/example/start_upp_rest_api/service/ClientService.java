package com.example.start_upp_rest_api.service;

import com.example.start_upp_rest_api.exception.InvalidClientDataException;
import com.example.start_upp_rest_api.models.Client;
import com.example.start_upp_rest_api.util.file.FileWriterUtils;
import com.example.start_upp_rest_api.validation.client.ClientValidation;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private static final String CLIENT_FILE_NAME = "clients.txt";

    /**
     * Добавляет клиента в файл после валидации данных.
     *
     * @param client объект клиента, который нужно добавить
     * @throws InvalidClientDataException если данные клиента некорректны
     */
    public void addClient(Client client) throws InvalidClientDataException {
        FileWriterUtils.writeToFile(CLIENT_FILE_NAME, ClientValidation.validation(client));
    }
}
