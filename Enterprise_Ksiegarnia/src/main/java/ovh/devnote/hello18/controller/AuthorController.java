package ovh.devnote.hello18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Ksiazka;
import ovh.devnote.hello18.services.AuthorService;
import ovh.devnote.hello18.services.BookService;


import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    //@RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomers(Model model)
    {
        List<Autor> autorzy = authorService.getAuthors();

        model.addAttribute("autorzy",autorzy);
        return "authorlist";
    }

    @GetMapping("/authorformadd")
    public String addForm(Model model)
    {
        Autor autor = new Autor();
        model.addAttribute("author",autor);
        return "addauthorform";
    }

    @PostMapping("/saveAuthor")
    public String saveAuthor(@ModelAttribute("author") Autor autor)
    {
        if (autor.getId() != 0) {
            Set<Ksiazka> books = bookService.getBooksByAuthor(autor);
            autor.setKsiazki(books);
        }

        authorService.saveAuthor(autor);

        return "redirect:/authors/list";
    }

    @GetMapping("/updateAuthor")
    public String updateForm2(@RequestParam("authorId") int id, Model model) {
        Autor author = authorService.getAuthor(id);

        if (author == null)
        {
            return "redirect:/404";
        }

        model.addAttribute("author", author);

        return "addauthorform";
    }

    @GetMapping("/deleteAuthor")
    public String deleteBookForm(@RequestParam("authorId") int id, Model model) {
        Autor author = authorService.getAuthor(id);

        model.addAttribute("author", author);
        return "deleteauthorform";
    }

    @PostMapping("/deleteAuthor")
    public String deleteBook(@ModelAttribute("author") Autor author, Model model) {
        authorService.deleteAuthor(author);
        return "redirect:/authors/list";
    }

}



