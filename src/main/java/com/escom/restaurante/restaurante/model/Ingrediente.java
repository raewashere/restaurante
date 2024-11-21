package com.escom.restaurante.restaurante.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ingrediente")
public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Integer cantidad;
}
