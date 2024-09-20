package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "cliente")
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
    private String email;

    @Column(name = "celular")
    private String celphoneNumber;

    @Column(name = "direccion")
    private String address;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;  // Relación Uno a Muchos con Pet (Mascota)

    @OneToMany(mappedBy = "owner")
    private List<Quotes> quotes;  // Relación Uno a Muchos con Quotes (Citas)

    @OneToMany(mappedBy = "owner")
    private List<Bill> bills;  // Relación Uno a Muchos con Bill (Factura)
}
