package com.escom.restaurante.restaurante.controller;

import com.escom.restaurante.restaurante.model.Menu;
import com.escom.restaurante.restaurante.service.MenuService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @Operation(
        summary = "Lista de menus",
        description = "Regresa los datos de todos los menus",
        responses = {
            @ApiResponse(responseCode = "200", description = "Obtiene todos los menus", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @Operation(
        summary = "Un menu",
        description = "Regresa los datos de un menu indicado",
        responses = {
            @ApiResponse(responseCode = "200", description = "Obtiene datos de un menu de acuerdo a id", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable Long id) {
        return menuService.getMenuById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Guardar un menu",
        description = "Registra un menu nuevo",
        responses = {
            @ApiResponse(responseCode = "200", description = "Regresa los datos del proveedor registrado", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @PostMapping
    public Menu createMenu(@RequestBody Menu menu) {
        return menuService.saveMenu(menu);
    }

    @Operation(
        summary = "Borra un menu",
        description = "Elimina el registro de un menu mediante su id",
        responses = {
            @ApiResponse(responseCode = "200", description = "No regresa nada", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}
