package com.escom.restaurante.restaurante.service;

import com.escom.restaurante.restaurante.model.Pedido;
import com.escom.restaurante.restaurante.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
