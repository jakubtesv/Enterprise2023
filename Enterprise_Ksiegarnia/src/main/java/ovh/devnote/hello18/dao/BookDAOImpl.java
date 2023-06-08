package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;


import java.awt.print.Book;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override

    public List<Ksiazka> getBooks() {
        //sesja hibertabe
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Ksiazka> query = currentSession.createQuery(" from Ksiazka", Ksiazka.class);
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

}
