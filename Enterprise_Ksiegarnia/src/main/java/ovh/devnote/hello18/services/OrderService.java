package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrders();
    List<Order> getOrders(String username);
    void saveOrder(Order order);
    void completeOrder(int orderId);
}

