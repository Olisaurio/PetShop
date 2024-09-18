package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "factura")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id")
    private int id;

    @Column(name = "cliente_id")
    private String customerId; // Relacionado con el cliente (Owner)

    @Column(name = "monto_total")
    private double totalAmount;
}
