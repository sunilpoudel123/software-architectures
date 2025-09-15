package service;

import org.springframework.stereotype.Service;

@Service
public class SavingAccountService {

    public String createAccount() {
        return "account created";
    }

    public void deposit() {
        System.out.println("balance deposited");
    }

    public void withdraw() {
        System.out.println("balance withdrawn");

    }
}