package com.escom.restaurante.restaurante.controller;

import com.escom.restaurante.restaurante.model.Ingrediente;
import com.escom.restaurante.restaurante.service.IngredienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {
    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService) {
        this.ingredienteService = ingredienteService;
    }

    @Operation(
        summary = "Lista de ingredientes",
        description = "Regresa los datos de todos los ingredientes",
        responses = {
            @ApiResponse(responseCode = "200", description = "Obtiene todos los ingredientes", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping
    public List<Ingrediente> getAllIngredientes() {
        return ingredienteService.getAllIngredientes();
    }

    @Operation(
        summary = "Obtiene un ingrediente",
        description = "Regresa los datos de todos los proveedores",
        responses = {
            @ApiResponse(responseCode = "200", description = "Obtiene todos los proveedores", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> getIngredienteById(@PathVariable Long id) {
        return ingredienteService.getIngredienteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Guardar un ingrediente",
        description = "Registra un ingrediente nuevo",
        responses = {
            @ApiResponse(responseCode = "200", description = "Regresa los datos del ingrediente registrado", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @PostMapping
    public Ingrediente createIngrediente(@RequestBody Ingrediente ingrediente) {
        return ingredienteService.saveIngrediente(ingrediente);
    }

    @Operation(
        summary = "Borrar un ingrediente",
        description = "Elimina un ingrediente de la lista",
        responses = {
            @ApiResponse(responseCode = "200", description = "Borra un ingrediente de la lista", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngrediente(@PathVariable Long id) {
        ingredienteService.deleteIngrediente(id);
        return ResponseEntity.noContent().build();
    }
}
