package com.escom.restaurante.restaurante.service;

import com.escom.restaurante.restaurante.model.Ingrediente;
import com.escom.restaurante.restaurante.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    public Ingrediente createIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }
}
