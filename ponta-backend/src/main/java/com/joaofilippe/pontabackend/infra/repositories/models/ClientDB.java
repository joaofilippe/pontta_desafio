package com.joaofilippe.pontabackend.infra.repositories.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class ClientDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String email;
    public String city;

    public ClientDB(){}

    public ClientDB(
            Long id, String name, String email, String city
    ){
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
