package miu.edu.springcqrsstock.controller;

import miu.edu.springcqrsstock.domain.Stock;
import miu.edu.springcqrsstock.domain.StockEvent;
import miu.edu.springcqrsstock.repositories.StockRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
class StockCommandController {
    private final StockRepository repo;
    private final JmsTemplate jmsTemplate;

    public StockCommandController(StockRepository repo, JmsTemplate jmsTemplate) {
        this.repo = repo;
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public Stock add(@RequestBody Stock stock) {
        Stock saved = repo.save(stock);
        StockEvent event = new StockEvent();
        event.setProductNumber(saved.getProductNumber());
        event.setQuantity(saved.getQuantity());
        event.setType("CREATED");
        jmsTemplate.convertAndSend("stock-events", event, m -> {
            m.setStringProperty("_type", "StockEvent");
            return m;
        });
        return saved;
    }

    @DeleteMapping("/{productNumber}")
    public void delete(@PathVariable String productNumber) {
        repo.deleteById(productNumber);
        StockEvent event = new StockEvent();
        event.setProductNumber(productNumber);
        event.setType("DELETED");
        jmsTemplate.convertAndSend("stock-events", event);
    }

    @PutMapping("/{productNumber}")
    public Stock update(@PathVariable String productNumber, @RequestBody Stock updated) {
        Stock s = repo.findById(productNumber).orElseThrow();
        s.setQuantity(updated.getQuantity());
        Stock saved = repo.save(s);
        StockEvent event = new StockEvent();
        event.setProductNumber(saved.getProductNumber());
        event.setQuantity(saved.getQuantity());
        event.setType("UPDATED");
        jmsTemplate.convertAndSend("stock-events", event);
        return saved;
    }
}
