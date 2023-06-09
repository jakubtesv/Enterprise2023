package ovh.devnote.hello18.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ovh.devnote.hello18.entity.Autor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class AuthorDAOimpl implements AuthorDAO{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Autor> getAuthors() {
        //sesja hibertabe
        Session currentSession = sessionFactory.getCurrentSession();
        //zapytanie
        Query<Autor> query = currentSession.createQuery(" FROM Autor where id!=17", Autor.class);
        List<Autor> authors = query.getResultList();

        return authors ;
    }

    @Override

    public void saveAuthor(Autor author) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(author);
    }

    @Override
    public Set<Autor> getAuthorsByIds(List<Integer> authorsid) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query<Autor> query = currentSession.createQuery(" from Autor as a where a.id in (:ids)", Autor.class).setParameterList("ids", authorsid);
        Set<Autor> authors = query.getResultStream().collect(Collectors.toSet());
        return authors;
    }

    @Override
    public Autor getAuthor(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Autor.class, id);
    }

    @Override
    public void deleteAuthor(Autor author) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(author);
    }

    @Override
    public Set<Autor> getNullAuthor()
    {
        Session currentSession = sessionFactory.getCurrentSession();


        //w bazie musi byc "brak" pod id=17
        Query<Autor> query = currentSession.createQuery(" from Autor where id=17", Autor.class);
        List<Autor> list_autor = query.getResultList();
        Set<Autor> autor = new HashSet<>(list_autor);

        return autor;
    }

}
