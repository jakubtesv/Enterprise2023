package ovh.devnote.hello18.dao;

import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.List;

public interface CategoryDAO {
    public List<Kategoria> getCategories();

    public void saveCategory(Kategoria kategoria);

    public Kategoria getCategory(int id);
}
