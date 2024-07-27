package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.security.PrivateKey;
@Data
@Entity
@Table(name = "propietario" )
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propirtario")
    private int id;

    @Column(name = "nombres")
    private String name;

    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "correos")
    private  String email;

    @Column(name = "celular")
    private String celphoneNumbrer;

    @Column(name = "direccion")
    private String address;

    // getters and setters


}
