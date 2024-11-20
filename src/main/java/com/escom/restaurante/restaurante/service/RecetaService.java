package com.escom.restaurante.restaurante.service;

import com.escom.restaurante.restaurante.model.Receta;
import com.escom.restaurante.restaurante.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaService {

    @Autowired
    private RecetaRepository recetaRepository;

    public List<Receta> getAllRecetas() {
        return recetaRepository.findAll();
    }

    public Receta createReceta(Receta receta) {
        return recetaRepository.save(receta);
    }
}
