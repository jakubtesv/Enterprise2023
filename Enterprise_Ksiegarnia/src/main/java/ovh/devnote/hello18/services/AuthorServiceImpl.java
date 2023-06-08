package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.dao.AuthorDAO;
import ovh.devnote.hello18.entity.Autor;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{
    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public List<Autor> getAuthor() {
        List<Autor> authors = authorDAO.getAuthors();
        return authors;
    }

    @Override
    @Transactional
    public void saveAuthor(Autor autor) {
        authorDAO.saveAuthor(autor);

    }

}
