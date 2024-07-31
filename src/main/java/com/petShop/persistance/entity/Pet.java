package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "mascota" )
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mascota")
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "especie")
    private String species;

    @Column(name = "edad")
    private String age;

    @Column(name = "genero")
    private String gender;

    @Column(name = "cliente_id")
    private int clientId;

    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private  Owner Owner;

}
