package com.escom.restaurante.restaurante.repository;

import com.escom.restaurante.restaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}

