package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {

    private String drinkId;
    private String drinkName;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal itemTotal;
    private List<Customization> customizations = new ArrayList<>();

}
