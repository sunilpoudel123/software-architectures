package books.BookApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping(value = "hello")
    public String sayHello() {
        return "Hello World";
    }
}
