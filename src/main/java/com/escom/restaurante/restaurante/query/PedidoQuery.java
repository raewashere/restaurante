package com.escom.restaurante.restaurante.query;

import com.escom.restaurante.restaurante.model.Pedido;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PedidoQuery {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Pedido> findPedidosByEstado(String estado) {
        String query = "SELECT p FROM Pedido p WHERE p.estado = :estado";
        return entityManager.createQuery(query, Pedido.class)
                .setParameter("estado", estado)
                .getResultList();
    }

    public List<Pedido> findPedidosByFecha(java.util.Date fecha) {
        String query = "SELECT p FROM Pedido p WHERE p.fecha = :fecha";
        return entityManager.createQuery(query, Pedido.class)
                .setParameter("fecha", fecha)
                .getResultList();
    }
}
