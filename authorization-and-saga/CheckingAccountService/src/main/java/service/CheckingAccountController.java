package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class CheckingAccountController {
    @Autowired
    private CheckingAccountService service;

    @PostMapping("/create")
    public void create() {
        service.createAccount();
    }

    @PostMapping("/deposit")
    public void deposit() {
        service.deposit();
    }

    @PostMapping("/withdraw")
    public void withdraw() {
        service.withdraw();
    }
}

