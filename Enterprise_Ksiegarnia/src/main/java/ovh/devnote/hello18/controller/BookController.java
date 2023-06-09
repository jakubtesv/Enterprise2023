package ovh.devnote.hello18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import ovh.devnote.hello18.dto.BookDTO;
import ovh.devnote.hello18.entity.Autor;
import ovh.devnote.hello18.entity.Kategoria;
import ovh.devnote.hello18.entity.Ksiazka;
import ovh.devnote.hello18.services.AuthorService;
import ovh.devnote.hello18.services.BookService;
import ovh.devnote.hello18.services.CategoryService;
import ovh.devnote.hello18.services.CategoryServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    //@RequestMapping("/list")
    @GetMapping("/list")
    public String listCustomers(Model model)
    {
        List<Ksiazka> books = bookService.getBooks();
        model.addAttribute("books",books);
        return "bookslist";
    }

//    @GetMapping("/bookformadd")
//    public String addForm(Model model)
//    {
//        Ksiazka book = new Ksiazka();
//        List<Kategoria> categories = categoryService.getCategories();
//
//        model.addAttribute("book",book);
//        model.addAttribute("categories",categories);
//        return "addbookform";
//    }

//    @PostMapping("/saveBook")
//    public String saveBook(@ModelAttribute("book") Ksiazka ksiazka)
//    {
//        bookService.saveBook(ksiazka);
//        return "redirect:/books/list";
//    }

    @PostMapping("/saveBook2")
    public String saveBook2(@ModelAttribute("bookDTO") BookDTO bookDTO)
    {
        int id =bookDTO.getId();
        Ksiazka newks = bookService.getBook(id);
        if (newks==null){
            newks = new Ksiazka();
        }


        Kategoria kat = categoryService.getCategory(bookDTO.getKategoriaid());
        newks.setKategoria(kat);
        newks.setNazwa(bookDTO.getNazwa());
        newks.setWydawnictwo(bookDTO.getWydawnictwo());
        newks.setCena(bookDTO.getCena());
        newks.setAutorzy(authorService.getAuthorsByIds(bookDTO.getAuthorsid()));

        bookService.saveBook(newks);
        return "redirect:/books/list";
    }

    @GetMapping("/formadd2")
    public String addForm2(Model model) {
        BookDTO bookDTO = new BookDTO();
        model.addAttribute("bookDTO", bookDTO);
        model.addAttribute("categories", categoryService.getCategories());
        model.addAttribute("authors", authorService.getAuthors());
        return "addbookform2";
    }

    @GetMapping("updateBookForm2")
    public String updateBookForm(@RequestParam("bookId")int bookid,Model model){
        Ksiazka ksiazka = bookService.getBook(bookid);
        BookDTO bookDTO = new BookDTO();
        if(ksiazka!=null){
            bookDTO.setId(ksiazka.getId());
            bookDTO.setCena(ksiazka.getCena());
            bookDTO.setWydawnictwo(ksiazka.getWydawnictwo());
            bookDTO.setNazwa(ksiazka.getNazwa());
            bookDTO.setKategoriaid(ksiazka.getKategoria().getId());
            bookDTO.setAuthorsid(ksiazka.getAuthorsIds());
        }
        model.addAttribute("bookDTO",bookDTO);
        List<Kategoria> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);
        List<Autor> authors = authorService.getAuthors();
        model.addAttribute("authors", authors);

        return "addbookform2";
    }

    @GetMapping("/deleteBook")
    public String deleteBookForm(@RequestParam("bookId") int id, Model model){
        Ksiazka ksiazka = bookService.getBook(id);
        model.addAttribute("book", ksiazka);
        return "deletebookform";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@ModelAttribute("book") Ksiazka ksiazka){
        bookService.deleteBook(ksiazka);
        return "redirect:/books/list";
    }


}
