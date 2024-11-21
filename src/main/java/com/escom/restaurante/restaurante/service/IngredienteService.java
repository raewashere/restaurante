package com.escom.restaurante.restaurante.service;

import com.escom.restaurante.restaurante.model.Ingrediente;
import com.escom.restaurante.restaurante.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteService {
    private final IngredienteRepository ingredienteRepository;

    public IngredienteService(IngredienteRepository ingredienteRepository) {
        this.ingredienteRepository = ingredienteRepository;
    }

    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    public Optional<Ingrediente> getIngredienteById(Long id) {
        return ingredienteRepository.findById(id);
    }

    public Ingrediente saveIngrediente(Ingrediente ingrediente) {
        return ingredienteRepository.save(ingrediente);
    }

    public void deleteIngrediente(Long id) {
        ingredienteRepository.deleteById(id);
    }
}
