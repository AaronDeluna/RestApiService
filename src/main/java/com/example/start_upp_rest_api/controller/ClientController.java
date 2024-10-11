package com.example.start_upp_rest_api.controller;

import com.example.start_upp_rest_api.exception.InvalidClientDataException;
import com.example.start_upp_rest_api.models.Client;
import com.example.start_upp_rest_api.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/clients")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    /**
     * Добавляет нового клиента.
     *
     * @param client объект {@link Client} с данными клиента.
     * @return {@link ResponseEntity} с сообщением и статусом 201 (CREATED) или 400 (BAD_REQUEST) при ошибке.
     */
    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody Client client) {
        try {
            clientService.addClient(client);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (InvalidClientDataException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
