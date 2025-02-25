package com.example.CreditCard_TokenProject.controller;

import com.example.CreditCard_TokenProject.dao.CreditCardDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/creditcards")
public class CreditCardController {

    private final CreditCardDAO creditCardDAO;

    public CreditCardController() {
        this.creditCardDAO = new CreditCardDAO(); // Initialize the DAO instance
    }

    // Endpoint to fetch the last four digits and token data for all credit cards
    @GetMapping("/last-four-and-token")
    public List<Map<String, String>> getCreditCardLastFourAndTokens() {
        return creditCardDAO.getLastFourDigitsAndTokens(); // Calls DAO method
    }
}