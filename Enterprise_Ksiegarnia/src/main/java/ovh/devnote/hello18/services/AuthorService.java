package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Autor;

import java.util.List;

public interface AuthorService {
    List<Autor> getAuthor();

    public void saveAuthor(Autor autor);
}