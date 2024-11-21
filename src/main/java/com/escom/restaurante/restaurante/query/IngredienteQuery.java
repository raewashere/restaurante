package com.escom.restaurante.restaurante.query;

import com.escom.restaurante.restaurante.model.Ingrediente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IngredienteQuery {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Ingrediente> findIngredientesByNombre(String nombre) {
        String query = "SELECT i FROM Ingrediente i WHERE i.nombre LIKE :nombre";
        return entityManager.createQuery(query, Ingrediente.class)
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
    }

    public List<Ingrediente> findIngredientesByCantidadMenorA(Integer cantidad) {
        String query = "SELECT i FROM Ingrediente i WHERE i.cantidad < :cantidad";
        return entityManager.createQuery(query, Ingrediente.class)
                .setParameter("cantidad", cantidad)
                .getResultList();
    }
}
