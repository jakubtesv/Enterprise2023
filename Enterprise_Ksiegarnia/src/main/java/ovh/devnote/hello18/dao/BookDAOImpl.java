package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.entity.*;


import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override

    public List<Ksiazka> getBooks() {
        //sesja hibertabe
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie


        Query<Ksiazka> query = currentSession.createQuery("SELECT DISTINCT k from Ksiazka as k LEFT JOIN FETCH k.autorzy", Ksiazka.class);
        List<Ksiazka> books = query.getResultList();

        return books ;
    }

    @Override
    public void saveBook(Ksiazka ksiazka) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(ksiazka);
    }

    @Override
    public Ksiazka getBook(int bookid) {
        Session session = sessionFactory.getCurrentSession();
        Ksiazka ksiazka = session.get(Ksiazka.class,bookid);
        return ksiazka;
    }

    @Override
    public void deleteBook(Ksiazka book) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(book);
    }


    @Override
    public Set<Ksiazka> getBooksByAuthor(Autor autor) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Ksiazka> query = currentSession.createQuery(" from Ksiazka k where :autor in ELEMENTS(k.autorzy)", Ksiazka.class).setParameter("autor", autor);
        Set<Ksiazka> books = query.getResultStream().collect(Collectors.toSet());

        return books;
    }

    @Override
    public Set<Ksiazka> getBooksByIds(List<Integer> booksId) {
        Session currentSession = sessionFactory.getCurrentSession();

        if (booksId.isEmpty())
        {
            return new HashSet<>();
        }

        Query<Ksiazka> query = currentSession.createQuery(" from Ksiazka as k where k.id in (:booksId)", Ksiazka.class).setParameterList("booksId", booksId);
        Set<Ksiazka> books = query.getResultStream().collect(Collectors.toSet());

        return books;
    }

    public boolean waliduj(Ksiazka ksiazka)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        int id_ksiazki = ksiazka.getId();

        String hqlQuery = "SELECT o FROM Order o JOIN o.ksiazki k WHERE k.id = :id_ksiazki";
        List<Order> orders = currentSession.createQuery(hqlQuery, Order.class)
                .setParameter("id_ksiazki", id_ksiazki)
                .getResultList();

        if(orders.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }




}
