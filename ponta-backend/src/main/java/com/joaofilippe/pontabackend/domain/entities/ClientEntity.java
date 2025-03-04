package com.joaofilippe.pontabackend.domain.entities;

public class ClientEntity {
    private final Long id;
    private final String name;
    private final String email;
    private final String city;

    public ClientEntity(Long id, String name, String email, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public ClientEntity copyWith(
            Long id, String name, String email, String city
    ){
        return new ClientEntity(
                id == null ? this.id : id,
                name == null ? this.name : name,
                email == null ? this.email : email,
                city == null ? this.city : city
        );
    }
}
