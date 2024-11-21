package com.escom.restaurante.restaurante.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true,length = 100)
    private String nombre;

    @Column(nullable = false)
    private int cantidad;
}
