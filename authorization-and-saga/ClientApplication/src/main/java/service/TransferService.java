package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransferService {
    @Autowired
    private RestTemplate restTemplate;

    public void transfer(Double amount) {

        try {

            restTemplate.postForObject("http://localhost:8091/withdraw/", null, Void.class);

            if (amount == 1000) {
                throw new RuntimeException("Simulated error during transfer!");
            }

            restTemplate.postForObject("http://localhost:8092/deposit/", null, Void.class);

        } catch (Exception e) {

            restTemplate.postForObject(
                    "http://localhost:8091/deposit/", null, Void.class);
            throw e;
        }

    }
}
