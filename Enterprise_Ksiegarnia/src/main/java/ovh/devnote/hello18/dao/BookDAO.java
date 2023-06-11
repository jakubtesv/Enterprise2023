package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Ksiazka;


import java.util.List;
import java.util.Set;

public interface BookDAO {
    public List<Ksiazka> getBooks();

    public void saveBook(Ksiazka ksiazka);
    public Ksiazka getBook(int id);

    void deleteBook(Ksiazka book);
    Set<Ksiazka> getBooksByAuthor(Autor autor);

    Set<Ksiazka> getBooksByIds(List<Integer> booksId);
}
