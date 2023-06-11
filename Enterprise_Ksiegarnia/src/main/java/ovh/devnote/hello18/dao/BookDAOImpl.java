package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;


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

}
