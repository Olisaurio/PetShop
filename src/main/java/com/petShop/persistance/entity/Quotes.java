package com.petShop.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "citas" )
public class Quotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cita_id")
    private int id;

    @Column(name = "cliente_id")
    private String customerId   ;

    @Column(name = "fecha_cita")
    private String appointmentDate;


    @ManyToOne
    @JoinColumn(name = "id_propietario")
    private  Owner Owner;

}
