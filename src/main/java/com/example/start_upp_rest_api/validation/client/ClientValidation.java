package com.example.start_upp_rest_api.validation.client;

import com.example.start_upp_rest_api.exception.InvalidClientDataException;
import com.example.start_upp_rest_api.models.Client;

public class ClientValidation {

    /**
     * Проверка клиента который добавляется через форму
     * @param client
     * @return
     * @throws InvalidClientDataException
     */
    public static Client validation(Client client) throws InvalidClientDataException {
        if (!NameValidation.isCorrectName(client.getName())){
            throw new InvalidClientDataException("Ошибка: имя клинета не может быть пустым");
        }
        if (!PhoneNumberValidation.isCorrectPhoneNumber(client.getPhoneNumber())) {
            throw new InvalidClientDataException("Ошибка: не корректный ввод номера телефона");
        }
        return client;
    }
}
