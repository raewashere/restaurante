package com.escom.restaurante.restaurante.controller;

import com.escom.restaurante.restaurante.model.Pedido;
import com.escom.restaurante.restaurante.service.PedidoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @Operation(
        summary = "Lista de pedidos",
        description = "Regresa todos los pedidos",
        responses = {
            @ApiResponse(responseCode = "200", description = "Obtiene una lista de todos los pedidos", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoService.getAllPedidos();
    }

    @Operation(
        summary = "Obtener pedido especifico",
        description = "Regresa el pedido de acuerdo a id",
        responses = {
            @ApiResponse(responseCode = "200", description = "Informacion del pedido especifico", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) {
        return pedidoService.getPedidoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
        summary = "Crea pedido nuevo",
        description = "Agrega un pedido nuevo a la base de datos",
        responses = {
            @ApiResponse(responseCode = "200", description = "Datos del pedido recien creado", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoService.savePedido(pedido);
    }

    @Operation(
        summary = "Borrar pedido",
        description = "Agrega un pedido nuevo a la base de datos",
        responses = {
            @ApiResponse(responseCode = "200", description = "Datos del pedido recien creado", 
                         content = @Content(mediaType = "application/json"))
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Long id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}
