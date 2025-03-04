package com.joaofilippe.pontabackend.application.api.controllers;

import ch.qos.logback.core.net.server.Client;
import com.joaofilippe.pontabackend.application.requests.CreateClientRequest;
import com.joaofilippe.pontabackend.application.requests.UpdateClientRequest;
import com.joaofilippe.pontabackend.domain.entities.ClientEntity;
import com.joaofilippe.pontabackend.domain.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    private final IClientService clientService;


    @Autowired
    public ClientController(final IClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/client")
    public ResponseEntity<String> create(@RequestBody CreateClientRequest request) {
        ClientEntity client = new ClientEntity(
                null,
                request.name,
                request.email,
                request.city
        );

        this.clientService.save(client);
        return new ResponseEntity<String>("usuário criado com sucesso", HttpStatus.CREATED);
    }

    @GetMapping("/client")
    public ResponseEntity<Iterable<ClientEntity>> getAll() {
        Iterable<ClientEntity> clients = this.clientService.getAll();

        return ResponseEntity.ok(clients);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientEntity> get(@PathVariable Long id) {
        ClientEntity client = this.clientService.getById(id);
        return ResponseEntity.ok(client);
    }

    @PutMapping("/client/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody UpdateClientRequest request) {
        ClientEntity newClient = new ClientEntity(
                null,
                request.name,
                request.email,
                request.city
        );


        ClientEntity updatedClient = this.clientService.update(id, newClient);
        if (updatedClient == null) {
            return new ResponseEntity<>("usuário com o id informado não encontrado",HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(updatedClient);

    }

    @DeleteMapping("/client/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        ClientEntity client = this.clientService.getById(id);
        if (client == null) {
            return new ResponseEntity<>("usuário com o id informado não encontrado", HttpStatus.BAD_REQUEST);
        }

        this.clientService.delete(id);
        return new ResponseEntity<>("usuário deletado com sucesso", HttpStatus.OK);
    }
}
