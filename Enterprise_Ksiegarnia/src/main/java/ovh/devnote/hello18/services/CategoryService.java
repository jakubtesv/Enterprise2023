package ovh.devnote.hello18.services;

import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.List;

public interface CategoryService
{
    List<Kategoria> getCategories();

    Kategoria getCategory(int id);

    public void saveCategory(Kategoria category);

}
