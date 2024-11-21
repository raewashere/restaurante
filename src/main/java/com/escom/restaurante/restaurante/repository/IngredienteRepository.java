package com.escom.restaurante.restaurante.repository;

import com.escom.restaurante.restaurante.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
}

