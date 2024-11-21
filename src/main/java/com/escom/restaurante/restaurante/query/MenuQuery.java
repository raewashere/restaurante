package com.escom.restaurante.restaurante.query;

import com.escom.restaurante.restaurante.model.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MenuQuery {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Menu> findMenusByNombre(String nombre) {
        String query = "SELECT m FROM Menu m WHERE m.nombre LIKE :nombre";
        return entityManager.createQuery(query, Menu.class)
                .setParameter("nombre", "%" + nombre + "%")
                .getResultList();
    }
}
