package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Ksiazka;


import java.util.List;

public interface BookDAO {
    public List<Ksiazka> getBooks();

    public void saveBook(Ksiazka ksiazka);
    public Ksiazka getBook(int id);

    void deleteBook(Ksiazka book);
}
