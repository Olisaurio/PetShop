package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "propietario" )
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_propietario")
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

    @OneToMany(mappedBy = "Owner")
    private List<Pet> pets;


}
