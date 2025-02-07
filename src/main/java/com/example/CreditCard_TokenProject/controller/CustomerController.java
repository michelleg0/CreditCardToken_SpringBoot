package com.example.CreditCard_TokenProject.controller;

import com.example.CreditCard_TokenProject.dao.CustomerDAO;
import com.example.CreditCard_TokenProject.entity.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //API controller
@RequestMapping("/api/customers")  // Base URL for this controller
public class CustomerController {

    private final CustomerDAO customerDAO;

    public CustomerController() {
        this.customerDAO = new CustomerDAO();  // Create DAO instance
    }

    // Fetch all customers
    @GetMapping("/list")
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();  // Calls DAO method to fetch data
    }


    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerDAO.getCustomer(id);  // Calls DAO method to fetch customer
    }
}
