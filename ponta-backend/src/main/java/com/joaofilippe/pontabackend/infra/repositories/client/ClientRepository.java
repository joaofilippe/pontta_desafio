package com.joaofilippe.pontabackend.infra.repositories.client;

import com.joaofilippe.pontabackend.domain.entities.ClientEntity;
import com.joaofilippe.pontabackend.domain.repository.IClientRepository;
import com.joaofilippe.pontabackend.infra.repositories.models.ClientDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientRepository implements IClientRepository {
    private ClientJpaRepository clientJpaRepository;

    @Autowired
    public ClientRepository(ClientJpaRepository clientJpaRepository) {
        this.clientJpaRepository = clientJpaRepository;
    }


    @Override
    public ClientEntity save(ClientEntity client) {
        ClientDB clientDB = toDbModel(client);
        ClientDB result = clientJpaRepository.save(clientDB);
        return toEntity(result);
    }

    @Override
    public Iterable<ClientEntity> getAll() {
        Iterable<ClientDB> result = clientJpaRepository.findAll();
        List<ClientEntity> list = new ArrayList<>();
        for (ClientDB clientDB : result) {
            list.add(toEntity(clientDB));
        }

        return list;
    }

    @Override
    public ClientEntity getById(Long id) {
        ClientDB clientDB = clientJpaRepository.findById(id).orElse(null);
        if (clientDB == null) return null;
        return toEntity(clientDB);
    }

    @Override
    public ClientEntity update(ClientEntity client) {
        ClientDB updatedClient = clientJpaRepository.save(toDbModel(client));
        return toEntity(updatedClient);
    }

    @Override
    public void delete(Long id) {
        this.clientJpaRepository.deleteById(id);
    }

    public ClientDB toDbModel(ClientEntity client) {
        return new ClientDB(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getCity()
        );
    }

    public ClientEntity toEntity(ClientDB client) {
        return new ClientEntity(
                client.id,
                client.name,
                client.email,
                client.city
        );
    }
}
