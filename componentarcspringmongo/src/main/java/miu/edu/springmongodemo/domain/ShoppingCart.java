package miu.edu.springmongodemo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "shopping_carts")
public class ShoppingCart {

    @Id
    private String customer;
    private List<CartItem> items = new ArrayList<>();

    public ShoppingCart(String customer) {
        this.customer = customer;
    }

    public void addItem(CartItem newItem) {
        for (CartItem item : items) {
            if (item.getProduct().getProductId().equals(newItem.getProduct().getProductId())) {
                item.setQuantity(item.getQuantity() + newItem.getQuantity());
                return;
            }
        }
        items.add(newItem);
    }

    public void removeItem(String productId) {
        items.removeIf(item -> item.getProduct().getProductId().equals(productId));
    }

    public void changeQuantity(String productId, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getProductId().equals(productId)) {
                item.setQuantity(quantity);
                break;
            }
        }
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(i -> i.getQuantity() * i.getProduct().getPrice())
                .sum();
    }

    public List<CartItem> getItems() {
        return items;
    }
}
