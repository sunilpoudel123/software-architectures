package miu.edu.springcqrsproductquery.messaging;

import miu.edu.springcqrsproductquery.domain.*;
import miu.edu.springcqrsproductquery.repositories.ProductQueryRepository;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
class ProductQueryEventListener {

    private final ProductQueryRepository queryRepository;

    public ProductQueryEventListener(ProductQueryRepository queryRepository) {
        this.queryRepository = queryRepository;
    }

    @JmsListener(destination = "product-events")
    public void handleProductEvent(ProductEvent event) {
        if ("CREATED".equals(event.getType()) || "UPDATED".equals(event.getType())) {
            ProductView view = queryRepository.findById(event.getProductNumber()).orElse(new ProductView());
            view.setProductNumber(event.getProductNumber());
            view.setName(event.getName());
            view.setPrice(event.getPrice());
            queryRepository.save(view);
        } else if ("DELETED".equals(event.getType())) {
            queryRepository.deleteById(event.getProductNumber());
        }
    }

    @JmsListener(destination = "stock-events")
    public void handleStockEvent(StockEvent event) {
        if ("CREATED".equals(event.getType()) || "UPDATED".equals(event.getType())) {
            ProductView view = queryRepository.findById(event.getProductNumber()).orElse(new ProductView());
            view.setProductNumber(event.getProductNumber());
            view.setNumberInStock(event.getQuantity());
            queryRepository.save(view);
        } else if ("DELETED".equals(event.getType())) {
            queryRepository.findById(event.getProductNumber()).ifPresent(v -> {
                v.setNumberInStock(0);
                queryRepository.save(v);
            });
        }
    }
}