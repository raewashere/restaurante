package com.escom.restaurante.restaurante.controller;

import com.escom.restaurante.restaurante.model.Receta;
import com.escom.restaurante.restaurante.service.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {

    @Autowired
    private RecetaService recetaService;

    @GetMapping
    public List<Receta> getAllRecetas() {
        return recetaService.getAllRecetas();
    }

    @PostMapping
    public Receta createReceta(@RequestBody Receta receta) {
        return recetaService.createReceta(receta);
    }
}
