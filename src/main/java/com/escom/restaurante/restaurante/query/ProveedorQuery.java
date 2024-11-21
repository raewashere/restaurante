package com.escom.restaurante.restaurante.query;

import com.escom.restaurante.restaurante.model.Proveedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProveedorQuery {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Proveedor> findProveedoresByNombre(String nombre) {
        String query = "SELECT p FROM Proveedor p WHERE p.nombre LIKE :nombre";
        return entityManager.createQuery(query, Proveedor.class)
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
    }
}
