package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.Drink;
import org.springframework.stereotype.Service;
import org.example.repository.DrinkRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class MenuService {

    private final DrinkRepository drinkRepository;

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

}
