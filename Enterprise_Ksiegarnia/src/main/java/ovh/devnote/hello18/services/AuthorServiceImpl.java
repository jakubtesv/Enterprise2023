package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.dao.AuthorDAO;
import ovh.devnote.hello18.entity.Autor;

import java.util.List;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public List<Autor> getAuthors() {
        List<Autor> authors = authorDAO.getAuthors();
        return authors;
    }

    @Override
    @Transactional
    public void saveAuthor(Autor autor) {
        authorDAO.saveAuthor(autor);

    }

    @Override
    @Transactional
    public Set<Autor> getAuthorsByIds(List<Integer> authorsid) {
        return authorDAO.getAuthorsByIds(authorsid);
    }

    @Override
    @Transactional
    public Autor getAuthor(int id) {
        return authorDAO.getAuthor(id);
    }

    @Override
    @Transactional
    public void deleteAuthor(Autor author) {
        authorDAO.deleteAuthor(author);
    }

    @Override
    @Transactional
    public Set<Autor> getNullAuthors() {
        return authorDAO.getNullAuthor();
    }


}
