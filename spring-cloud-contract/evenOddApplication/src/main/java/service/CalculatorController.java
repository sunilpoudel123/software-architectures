package service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public String addTwoNumber(@RequestParam("value1") Integer value1, @RequestParam("value2") Integer value2) {
        return String.valueOf(value1 + value2);
    }

    @GetMapping("/double")
    public String add(@RequestParam("number") Integer number) {
        return number+number+"";
    }
}
