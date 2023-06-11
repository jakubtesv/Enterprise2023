package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.List;
import java.util.Set;

public interface BookService {
    List<Ksiazka> getBooks();

    Ksiazka getBook(int id);

    public void saveBook(Ksiazka ksiazka);

    void deleteBook(Ksiazka book);

    Set<Ksiazka> getBooksByAuthor(Autor author);

    Set<Ksiazka> getBooksByIds(List<Integer> ids);
}
