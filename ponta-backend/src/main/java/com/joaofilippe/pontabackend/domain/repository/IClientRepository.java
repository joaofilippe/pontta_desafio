package com.joaofilippe.pontabackend.domain.repository;

import com.joaofilippe.pontabackend.domain.entities.ClientEntity;

public interface IClientRepository {
    ClientEntity save(ClientEntity client);

    Iterable<ClientEntity> getAll();

    ClientEntity getById(Long id);

    ClientEntity update(ClientEntity client);

    void delete(Long id);
}
