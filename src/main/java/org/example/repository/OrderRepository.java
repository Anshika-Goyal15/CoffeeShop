package org.example.repository;

import org.example.dto.Order;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepository {

    private final Map<String, Order> orders = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Order save(Order order) {
        if (order.getId() == null) {
            order.setId(String.valueOf(idGenerator.getAndIncrement()));
        }
        orders.put(order.getId(), order);
        return order;
    }
    public Optional<Order> findById(String id) {
        return Optional.ofNullable(orders.get(id));
    }
}
