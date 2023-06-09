package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Autor;


import java.util.List;
import java.util.Set;

public interface AuthorDAO
{
    public List<Autor> getAuthors();

    public void saveAuthor(Autor autor);

    Set<Autor> getAuthorsByIds(List<Integer> authorsid);

    Autor getAuthor(int id);

    void deleteAuthor(Autor author);

}
