package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.dao.BookDAO;
import ovh.devnote.hello18.dao.CategoryDAO;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.List;

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
        //List<Kategoria> kategorie = categoryDAO.getCategories();
        //ksiazka.setKategoria(kategorie.get(0));
//        Kategoria kategoria = ksiazka.getKategoria();
//        kategoria.setId(Integer.parseInt(kategoria.getNazwa()));

        bookDAO.saveBook(ksiazka);
    }

    @Override
    @Transactional
    public void deleteBook(Ksiazka book) {
        bookDAO.deleteBook(book);
    }

}
