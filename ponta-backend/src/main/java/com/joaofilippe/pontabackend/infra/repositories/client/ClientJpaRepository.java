package com.joaofilippe.pontabackend.infra.repositories.client;

import com.joaofilippe.pontabackend.infra.repositories.models.ClientDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<ClientDB, Long> {
}
