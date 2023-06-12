package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Order;

import java.util.List;

public interface OrderDAO {
    List<Order> getOrders();
    List<Order> getOrders(String username);
    void saveOrder(Order order);
    void completeOrder(int orderId);
}