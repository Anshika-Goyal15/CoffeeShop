package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.Customization;
import org.example.dto.Drink;
import org.example.repository.CustomizationRepository;
import org.springframework.stereotype.Service;
import org.example.repository.DrinkRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class MenuService {

    private final DrinkRepository drinkRepository;
    private final CustomizationRepository customizationRepository;

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public List<Customization> getAllCustomizations() {
        return customizationRepository.findAll();
    }
}
