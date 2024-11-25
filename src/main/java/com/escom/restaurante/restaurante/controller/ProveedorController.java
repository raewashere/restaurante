package com.escom.restaurante.restaurante.controller;

import com.escom.restaurante.restaurante.model.Proveedor;
import com.escom.restaurante.restaurante.service.ProveedorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @Operation(
        summary = "Lista de proveedores",
        description = "Regresa los datos de todos los proveedores",
        responses = {
            @ApiResponse(responseCode = "200", description = "Obtiene todos los proveedores", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorService.getAllProveedores();
    }

    @Operation(
        summary = "Obtiene un proveedor",
        description = "Regresa los datos de un proveedor de acuerdo a un id",
        responses = {
            @ApiResponse(responseCode = "200", description = "Obtiene objeto de tipo Proveedor", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Long id) {
        return proveedorService.getProveedorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Guardar un proveedor",
        description = "Registra un proveedor nueva",
        responses = {
            @ApiResponse(responseCode = "200", description = "Regresa los datos del proveedor registrado", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.saveProveedor(proveedor);
    }

    @Operation(
        summary = "Borra un proveedor",
        description = "Elimina el registro de un proveedor mediante su id",
        responses = {
            @ApiResponse(responseCode = "200", description = "No regresa nada", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        proveedorService.deleteProveedor(id);
        return ResponseEntity.noContent().build();
    }
}
