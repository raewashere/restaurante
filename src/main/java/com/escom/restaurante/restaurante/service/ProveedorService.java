package com.escom.restaurante.restaurante.service;

import com.escom.restaurante.restaurante.model.Proveedor;
import com.escom.restaurante.restaurante.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> getAllProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor createProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }
}
