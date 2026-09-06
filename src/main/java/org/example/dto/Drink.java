package org.example.dto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Drink {
    private String id;
    private String name;
    private BigDecimal basePrice;

    public Drink(String id, String americano, BigDecimal bigDecimal) {
    }
}
