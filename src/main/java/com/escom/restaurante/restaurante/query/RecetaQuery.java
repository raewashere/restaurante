package com.escom.restaurante.restaurante.query;

import com.escom.restaurante.restaurante.model.Receta;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecetaQuery {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Receta> findRecetasByNombre(String nombre) {
        String query = "SELECT r FROM Receta r WHERE r.nombre LIKE :nombre";
        return entityManager.createQuery(query, Receta.class)
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
    }
}
