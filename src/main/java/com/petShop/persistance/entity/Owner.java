package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cliente" )
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int id;

    @Column(name = "nombres")
    private String name;

    @Column(name = "apellidos")
    private String lastName;

    @Column(name = "correo")
    private  String email;

    @Column(name = "celular")
    private String celphoneNumbrer;

    @Column(name = "direccion")
    private String address;

    @OneToMany(mappedBy = "Owner")
    private List<Pet> pets;

    @OneToMany(mappedBy = "Owner")
    private List<Quotes> quotes;


}
