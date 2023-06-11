package ovh.devnote.hello18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ovh.devnote.hello18.component.Cart;
import ovh.devnote.hello18.services.BookService;

@Controller
public class CartController {
    private final Cart cart;
    private final BookService bookService;

    public CartController(Cart cart, BookService bookService) {
        this.cart = cart;
        this.bookService = bookService;
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("books", bookService.getBooksByIds(cart.getBookIds()));
        return "cart";
    }

    @PostMapping("/cart/add")
    public String addToCart(@RequestParam(name = "bookId") int id) {

        //dodawanie tylko 1 pozycji ksiazki
        if (cart.getBookIds().contains(id)) {

        }
        else
        {
            cart.addBookId(id);
        }
        return "redirect:/cart";
    }


    @PostMapping("/cart/delete")
    public String removeFromCart(@RequestParam("bookId") int id) {
        cart.deleteBookId(id);
        return "redirect:/cart";
    }



}
