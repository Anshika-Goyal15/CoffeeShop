package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.Customization;
import org.example.dto.Drink;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class PriceService {

    public BigDecimal calculateUnitPrice(Drink drink, List<Customization> customizations) {
        BigDecimal totalPrice = drink.getBasePrice();
        for (Customization customization : customizations) {
            totalPrice = totalPrice.add(customization.getPrice());
        }
        return totalPrice;
    }

}
