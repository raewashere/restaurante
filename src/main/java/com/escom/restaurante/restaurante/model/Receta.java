package com.escom.restaurante.restaurante.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "receta")
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(length = 500)
    private String descripcion;
}
