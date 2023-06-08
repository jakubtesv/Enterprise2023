package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Autor;


import java.util.List;

public interface AuthorDAO
{
    public List<Autor> getAuthors();

    public void saveAuthor(Autor autor);
}
