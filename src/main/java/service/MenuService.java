package service;

import dto.Drink;
import org.springframework.stereotype.Service;
import repository.DrinkRepository;

import java.util.List;
@Service
public class MenuService {

    private final DrinkRepository drinkRepository;

    public MenuService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

}
