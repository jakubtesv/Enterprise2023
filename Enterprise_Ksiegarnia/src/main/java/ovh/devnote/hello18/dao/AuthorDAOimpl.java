package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.List;

@Repository
public class AuthorDAOimpl implements AuthorDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Autor> getAuthors() {
        //sesja hibertabe
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Autor> query = currentSession.createQuery(" FROM Autor", Autor.class);
        List<Autor> authors = query.getResultList();

        return authors ;
    }

    @Override

    public void saveAuthor(Autor author) {
        Session session = sessionFactory.getCurrentSession();
        session.save(author);
    }

}
