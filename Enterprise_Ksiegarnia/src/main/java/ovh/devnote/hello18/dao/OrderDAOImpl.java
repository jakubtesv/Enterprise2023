package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Ksiazka;
import ovh.devnote.hello18.entity.Order;

import java.util.List;

@Repository
public class OrderDAOImpl implements OrderDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Order> getOrders() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Order> query = currentSession.createQuery(" FROM Order", Order.class);
        List<Order> orders = query.getResultList();

        return orders;
    }

    @Override
    public List<Order> getOrders(String username) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Order> query = currentSession.createQuery(" FROM Order where username=:username", Order.class);
        List<Order> orders = query.getResultList();

        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(order);
    }

    @Override
    public void completeOrder(int orderId) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.get(Order.class,orderId);
        order.setStatus("zrealizowane");
        session.saveOrUpdate(order);
    }
}
