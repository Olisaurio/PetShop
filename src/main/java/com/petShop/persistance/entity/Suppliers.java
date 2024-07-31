package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "proveedores" )
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String contactLastName;

    @Column(name = "email")
    private String contactEmail;

    @Column(name = "telefono")
    private String contactPhoneNumber;

    @Column(name = "direccion")
    private String address;


}
