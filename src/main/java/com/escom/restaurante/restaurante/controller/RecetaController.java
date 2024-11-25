package com.escom.restaurante.restaurante.controller;

import com.escom.restaurante.restaurante.model.Receta;
import com.escom.restaurante.restaurante.service.RecetaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {
    private final RecetaService recetaService;

    public RecetaController(RecetaService recetaService) {
        this.recetaService = recetaService;
    }


    @Operation(
        summary = "Obtener todas las recetas disponibles",
        description = "Regresa las recetas existentes",
        responses = {
            @ApiResponse(responseCode = "200", description = "Regresa un arreglo con las recetas existentes", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping
    public List<Receta> getAllRecetas() {
        return recetaService.getAllRecetas();
    }

    @Operation(
        summary = "Obtener una receta",
        description = "Regresa la receta de un id especifico",
        responses = {
            @ApiResponse(responseCode = "200", description = "Regresa un objeto receta", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Receta> getRecetaById(@PathVariable Long id) {
        return recetaService.getRecetaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Guardar una receta",
        description = "Registra una receta nueva",
        responses = {
            @ApiResponse(responseCode = "200", description = "Regresa los datos de la receta registrada", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @PostMapping
    public Receta createReceta(@RequestBody Receta receta) {
        return recetaService.saveReceta(receta);
    }

    @Operation(
        summary = "Borra una receta",
        description = "Elimina el registro de una receta",
        responses = {
            @ApiResponse(responseCode = "200", description = "No regresa nada", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceta(@PathVariable Long id) {
        recetaService.deleteReceta(id);
        return ResponseEntity.noContent().build();
    }
}
