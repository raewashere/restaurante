package com.escom.restaurante.restaurante.service;

import com.escom.restaurante.restaurante.model.Menu;
import com.escom.restaurante.restaurante.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu createMenu(Menu receta) {
        return menuRepository.save(receta);
    }
}
