package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.dao.OrderDAO;
import ovh.devnote.hello18.entity.Order;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderDAO orderDAO;

    @Override
    @Transactional
    public List<Order> getOrders() {
        List<Order> orders = orderDAO.getOrders();
        return orders;
    }

    @Override
    @Transactional
    public List<Order> getOrders(String username) {
        return orderDAO.getOrders(username);
    }

    @Override
    @Transactional
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public void completeOrder(int orderId) {
        orderDAO.completeOrder(orderId);
    }
}
