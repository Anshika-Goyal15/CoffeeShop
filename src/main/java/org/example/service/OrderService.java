package org.example.service;

import lombok.AllArgsConstructor;
import org.example.dto.*;
import org.example.repository.CustomizationRepository;
import org.example.repository.DrinkRepository;
import org.example.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private final DrinkRepository drinkRepository;
    private final CustomizationRepository customizationRepository;
    private final OrderRepository orderRepository;
    private final PriceService priceService;

    public Order createOrder(CreateOrderRequest request) {
        if (request.getItems() == null || request.getItems().isEmpty()) {
            throw new RuntimeException("No item is selected to place order");
        }
        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());

        List<OrderItems> orderItems = new ArrayList<>();
        BigDecimal orderTotal = BigDecimal.ZERO;
        for (OrderRequest itemRequest : request.getItems()) {
            Drink drink = drinkRepository.findById(itemRequest.getId()).orElseThrow(() ->
                    new RuntimeException("Drink not found with id: " + itemRequest.getId()));

            int quantity = itemRequest.getQuantity() == null ? 1 : itemRequest.getQuantity();
            if (quantity <= 0) {
                throw new RuntimeException("Quantity must be greater than zero");
            }

            List<Customization> selectedCustomizations = new ArrayList<>();
            if (itemRequest.getCustomizationIds() != null) {
                for (String customizationId : itemRequest.getCustomizationIds()) {
                    Customization customization = customizationRepository.findById(customizationId).orElseThrow(() ->
                            new RuntimeException("Customization not found with id: " + customizationId));
                    selectedCustomizations.add(customization);
                }
            }
            BigDecimal unitPrice = priceService.calculateUnitPrice(drink, selectedCustomizations);
            BigDecimal itemTotal = unitPrice.multiply(BigDecimal.valueOf(quantity));
            OrderItems orderItem = new OrderItems();
            orderItem.setDrinkId(drink.getId());
            orderItem.setDrinkName(drink.getName());
            orderItem.setQuantity(quantity);
            orderItem.setUnitPrice(drink.getBasePrice());
            orderItem.setItemTotal(itemTotal);
            orderItem.setCustomizations(selectedCustomizations);
            orderItems.add(orderItem);
            orderTotal = orderTotal.add(itemTotal);
        }
        order.setItems(orderItems);
        order.setTotalAmount(orderTotal);
        return orderRepository.save(order);
    }

    public Order getOrder(String id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }
}
