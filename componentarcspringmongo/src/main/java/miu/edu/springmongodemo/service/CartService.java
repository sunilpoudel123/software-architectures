package miu.edu.springmongodemo.service;

import miu.edu.springmongodemo.domain.CartItem;
import miu.edu.springmongodemo.domain.ShoppingCart;
import miu.edu.springmongodemo.repositories.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartDao cartDao;

    public ShoppingCart addItem(String customerId, CartItem item) {
        ShoppingCart cart = cartDao.findByCustomerId(customerId).orElse(new ShoppingCart(customerId));
        cart.addItem(item);
        return cartDao.save(cart);
    }

    public ShoppingCart removeItem(String customerId, String productId) {
        ShoppingCart cart = cartDao.findByCustomerId(customerId).orElse(null);
        if (cart != null) {
            cart.removeItem(productId);
            cartDao.save(cart);
        }
        return cart;
    }

    public ShoppingCart viewCart(String customerId) {
        return cartDao.findByCustomerId(customerId).orElse(null);
    }

    public void changeQuantity(String customerId, String productId, int quantity) {
        ShoppingCart cart = cartDao.findByCustomerId(customerId).orElse(null);
        if (cart != null) {
            cart.changeQuantity(productId, quantity);
            cartDao.save(cart);
        }
    }

    public void removeCart(String customerId) {
        cartDao.deleteById(customerId);
    }

    public boolean checkoutCart(String customerId) {
        ShoppingCart cart = cartDao.findByCustomerId(customerId).orElse(null);
        if (cart != null && !cart.getItems().isEmpty()) {
            cartDao.deleteById(customerId);
            return true;
        }
        return false;
    }
}