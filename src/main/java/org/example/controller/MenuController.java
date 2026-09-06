package org.example.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.dto.Customization;
import org.example.dto.Drink;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@AllArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @GetMapping("/drinks")
    public ResponseEntity<List<Drink>> getDrinks() {
        return ResponseEntity.ok(menuService.getAllDrinks());
    }

    @GetMapping("/customizations")
    public ResponseEntity<List<Customization>> getCustomizations() {
        return ResponseEntity.ok(menuService.getAllCustomizations());
    }

}
