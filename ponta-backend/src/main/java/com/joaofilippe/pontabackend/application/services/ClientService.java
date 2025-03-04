package com.joaofilippe.pontabackend.application.services;

import ch.qos.logback.core.net.server.Client;
import com.joaofilippe.pontabackend.domain.entities.ClientEntity;
import com.joaofilippe.pontabackend.domain.repository.IClientRepository;
import com.joaofilippe.pontabackend.domain.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements IClientService {
    private IClientRepository clientRepository;

    @Autowired
    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientEntity save(ClientEntity client) {
        return this.clientRepository.save(client);
    }

    @Override
    public Iterable<ClientEntity> getAll() {
        return this.clientRepository.getAll();
    }

    @Override
    public ClientEntity getById(Long id) {
        return this.clientRepository.getById(id);
    }

    @Override
    public ClientEntity update(Long id, ClientEntity client) {
        ClientEntity clientResult = this.clientRepository.getById(id);
        if (clientResult == null) {
            return null;
        }

        ClientEntity newClient = new ClientEntity(
                clientResult.getId(),
                client.getName(),
                client.getEmail(),
                client.getCity()
        );

        return this.clientRepository.update(newClient);
    }

    @Override
    public void delete(Long id) {
        this.clientRepository.delete(id);
    }
}
