package ovh.devnote.hello18.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ovh.devnote.hello18.dao.CategoryDAO;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService
{

    @Autowired
    CategoryDAO categoryDAO;


    @Override
    @Transactional
    public List<Kategoria> getCategories() {

        List<Kategoria> categories = categoryDAO.getCategories();
        return categories;
    }

    @Override
    @Transactional
    public Kategoria getCategory(int id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    @Transactional
    public void saveCategory(Kategoria category) {

    }
}
