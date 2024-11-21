package com.escom.restaurante.restaurante.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor;

    @Column(nullable = false, length = 100)
    private String nombre;
}
