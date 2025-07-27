package miu.edu.springmongodemo.controller;

import miu.edu.springmongodemo.domain.CartItem;
import miu.edu.springmongodemo.domain.ShoppingCart;
import miu.edu.springmongodemo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{customerId}/add")
    public ShoppingCart addItem(@PathVariable String customerId, @RequestBody CartItem item) {
        ShoppingCart cart = cartService.addItem(customerId, item);
        return cart;
    }

    @PostMapping("/{customerId}/remove")
    public ShoppingCart removeItem(@PathVariable String customerId, @RequestBody String productId) {
        return cartService.removeItem(customerId, productId);
    }

    @GetMapping("/{customerId}")
    public ShoppingCart viewCart(@PathVariable String customerId) {
        return cartService.viewCart(customerId);
    }
}
