package com.escom.restaurante.restaurante.service;

import com.escom.restaurante.restaurante.model.Receta;
import com.escom.restaurante.restaurante.repository.RecetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {
    private final RecetaRepository recetaRepository;

    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    public List<Receta> getAllRecetas() {
        return recetaRepository.findAll();
    }

    public Optional<Receta> getRecetaById(Long id) {
        return recetaRepository.findById(id);
    }

    public Receta saveReceta(Receta receta) {
        return recetaRepository.save(receta);
    }

    public void deleteReceta(Long id) {
        recetaRepository.deleteById(id);
    }
}
