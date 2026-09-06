package repository;

import dto.Drink;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DrinkRepository {

    private final Map<String, Drink> drinks = new ConcurrentHashMap<>();

    public DrinkRepository() {
        drinks.put("1", new Drink("1", "Americano", new BigDecimal("120.00")));
        drinks.put("2", new Drink("2", "Cappuccino", new BigDecimal("180.00")));
        drinks.put("3", new Drink("3", "Latte", new BigDecimal("170.00")));
        drinks.put("4", new Drink("4", "Mocha", new BigDecimal("200.00")));
        drinks.put("5", new Drink("5", "Espresso", new BigDecimal("100.00")));
    }

    public List<Drink> findAll() {
        return new ArrayList<>(drinks.values());
    }

}
