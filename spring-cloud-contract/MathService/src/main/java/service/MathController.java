package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MathController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/calculate")
    public String checkOddAndEven(@RequestParam("number1") Integer number1, @RequestParam("number2") Integer number2) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8905/validate?number1=" + number1 + "&number2=" + number2,
                HttpMethod.GET,
                new HttpEntity<>(httpHeaders),
                String.class);

        return responseEntity.getBody();
    }
}