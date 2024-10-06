package com.example.start_upp_rest_api.controller;

import com.example.start_upp_rest_api.exception.InvalidClientDataException;
import com.example.start_upp_rest_api.models.Client;
import com.example.start_upp_rest_api.service.FileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:3000")
public class ClientController {
    private FileService fileService;

    public ClientController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<String> addClient(@RequestBody Client client) {
        try {
            fileService.addClient(client);
            return new ResponseEntity<>("Клиент успешно записан", HttpStatus.CREATED);
        } catch (InvalidClientDataException e) {
            return new ResponseEntity<>("Ошибка: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
