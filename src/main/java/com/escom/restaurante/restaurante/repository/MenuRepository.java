package com.escom.restaurante.restaurante.repository;

import com.escom.restaurante.restaurante.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long> {
}

