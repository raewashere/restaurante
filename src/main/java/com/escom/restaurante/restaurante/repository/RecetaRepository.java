package com.escom.restaurante.restaurante.repository;

import com.escom.restaurante.restaurante.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {
}
