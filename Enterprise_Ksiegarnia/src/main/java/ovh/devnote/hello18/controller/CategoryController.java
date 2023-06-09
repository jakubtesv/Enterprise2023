package ovh.devnote.hello18.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String listCategories(Model model)
    {
        List<Kategoria> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);

        return "categorylist";
    }

    @GetMapping("/addCategory")
    public String addForm(Model model)
    {
        Kategoria category = new Kategoria();
        model.addAttribute("category", category);

        return "addcategoryform";
    }

    @PostMapping("/saveCategory")
    public String saveBook(@ModelAttribute("category") Kategoria category)
    {
        categoryService.saveCategory(category);

        return "redirect:/categories/list";
    }
}
