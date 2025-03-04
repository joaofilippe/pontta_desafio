package com.joaofilippe.pontabackend.domain.services;

import com.joaofilippe.pontabackend.domain.entities.ClientEntity;

public interface IClientService {
    ClientEntity save(ClientEntity client);

    Iterable<ClientEntity> getAll();

    ClientEntity getById(Long id);

    ClientEntity update(Long id, ClientEntity client);

    void delete(Long id);
}
