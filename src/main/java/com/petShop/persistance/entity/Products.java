package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "producto" )
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id")
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "precio")
    private double price;

    @Column(name = "cantidad_stock")
    private int stockQuantity;


}
