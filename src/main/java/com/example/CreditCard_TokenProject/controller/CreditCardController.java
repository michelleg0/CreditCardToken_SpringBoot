package com.example.CreditCard_TokenProject.controller;

import com.example.CreditCard_TokenProject.dao.CreditCardDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/credit-cards")
public class CreditCardController {

    private final CreditCardDAO creditCardDAO;

    public CreditCardController(CreditCardDAO creditCardDAO) {
        this.creditCardDAO = creditCardDAO;
    }

    // Endpoint to fetch only the last four digits
    @GetMapping("/last-four-digits")
    public List<String> getLastFourDigits() {
        return creditCardDAO.getLastFourDigits();
    }

    // Endpoint to fetch only the credit card tokens
    @GetMapping("/tokens")
    public List<String> getCreditCardTokens() {
        return creditCardDAO.getCreditCardTokens();
    }


}