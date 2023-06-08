package ovh.devnote.hello18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.services.AuthorService;


import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    //@RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomers(Model model)
    {
        List<Autor> autorzy = authorService.getAuthor();
        model.addAttribute("autorzy",autorzy);
        return "authorlist";
    }

    @GetMapping("/authorformadd")
    public String addForm(Model model)
    {
        Autor autor = new Autor();
        model.addAttribute("autor",autor);
        return "addauthorform";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("autorzy") Autor autor)
    {
        authorService.saveAuthor(autor);
        return "redirect:/authors/list";
    }
}



