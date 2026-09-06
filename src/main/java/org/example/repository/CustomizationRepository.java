package org.example.repository;

import org.example.dto.Customization;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomizationRepository {
    private final Map<String, Customization> customizations = new ConcurrentHashMap<>();

    public CustomizationRepository() {
        customizations.put("1", new Customization("1", "Extra Sugar", new BigDecimal("10.00")));
        customizations.put("2", new Customization("2", "Extra Shot", new BigDecimal("40.00")));
        customizations.put("3", new Customization("3", "Almond Milk", new BigDecimal("50.00")));
        customizations.put("4", new Customization("4", "Less Sugar/ Milk", BigDecimal.ZERO));
    }

    public List<Customization> findAll() {
        return new ArrayList<>(customizations.values());
    }

}
