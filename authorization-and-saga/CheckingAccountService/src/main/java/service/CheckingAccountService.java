package service;

import org.springframework.stereotype.Service;

@Service
public class CheckingAccountService {

    public String createAccount() {
        return "Checking account created";
    }

    public void deposit() {
        System.out.println("Checking balance deposited");
    }

    public void withdraw() {
        System.out.println("Checking balance withdrawn");

    }
}