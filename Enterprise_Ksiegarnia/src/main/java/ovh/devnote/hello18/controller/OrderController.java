package ovh.devnote.hello18.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ovh.devnote.hello18.component.Cart;
import ovh.devnote.hello18.entity.Order;
import ovh.devnote.hello18.entity.User;
import ovh.devnote.hello18.services.BookService;
import ovh.devnote.hello18.services.OrderService;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Controller
public class OrderController {

    private final Cart cart;

    private BookService bookService;

    private OrderService orderService;

    public OrderController(Cart cart, BookService bookService, OrderService orderService) {
        this.cart = cart;
        this.bookService = bookService;
        this.orderService = orderService;
    }

    @PostMapping("/addOrder")
    public String saveOrder(@RequestParam(name = "count") float count, Authentication authentication) {
        Order order = new Order();
        order.setStatus("zlozone");
        order.setUser(new User(authentication.getName()));
        order.setKsiazki(new HashSet<>(bookService.getBooksByIds(cart.getBookIds())));

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        order.setDate_time(date);
        order.setPrice(count);

        orderService.saveOrder(order);
        cart.getBookIds().clear();
        return "redirect:/home";
    }

    @PostMapping("/completeOrder")
    public String completeOrder(@RequestParam(name = "orderId") int id) {
        orderService.completeOrder(id);
        return "redirect:/orders";
    }

    @GetMapping("/orderList")
    public String orderList(Model model)
    {
        List<Order> orders = orderService.getOrders();
        model.addAttribute("orders",orders);
        return "orders";
    }


}
