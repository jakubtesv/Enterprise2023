package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.dao.BookDAO;
import ovh.devnote.hello18.dao.CategoryDAO;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDAO bookDAO;
    @Autowired
    CategoryDAO categoryDAO;

    @Override
    @Transactional
    public List<Ksiazka> getBooks() {
        List<Ksiazka> books = bookDAO.getBooks();
        return books;
    }

    @Override
    @Transactional
    public Ksiazka getBook(int id) {
        return bookDAO.getBook(id);
    }

    @Override
    @Transactional
    public void saveBook(Ksiazka ksiazka) {
        bookDAO.saveBook(ksiazka);
    }

    @Override
    @Transactional
    public void deleteBook(Ksiazka book) {
        bookDAO.deleteBook(book);
    }

    @Override
    @Transactional
    public Set<Ksiazka> getBooksByAuthor(Autor author) {
        return bookDAO.getBooksByAuthor(author);
    }

    @Override
    @Transactional
    public Set<Ksiazka> getBooksByIds(List<Integer> ids) {
        return bookDAO.getBooksByIds(ids);
    }

}
