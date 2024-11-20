package com.escom.restaurante.restaurante.repository;

import com.escom.restaurante.restaurante.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecetaRepository extends JpaRepository<Receta, Long> {
}
