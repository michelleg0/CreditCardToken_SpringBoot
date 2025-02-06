package com.example.CreditCard_TokenProject.entity; // Declaring the package

// Declaring the Customer class
public class Customer {
    // Instance variables
    public int id;            // Stores the customer's ID
    public String firstName;  // Stores the customer's first name
    public String lastName;   // Stores the customer's last name
    public String email;      // Stores the customer's email

    // Constructor to initialize the customer details
    // Parameters: id, firstName, lastName, email
    public Customer(int id, String firstName, String lastName, String email) {
        this.id = id;                 // Assigns the id parameter to the instance variable
        this.firstName = firstName;   // Assigns the firstName parameter to the instance variable
        this.lastName = lastName;     // Assigns the lastName parameter to the instance variable
        this.email = email;           // Assigns the email parameter to the instance variable
    }

    // Method to get the customer's ID
    public int getId() {
        return id; // Returns the id
    }

    // Method to set the customer's ID
    public void setId(int id) {
        this.id = id; // Sets the id
    }

    // Method to get the customer's first name
    public String getFirstName() {
        return firstName; // Returns the firstName
    }

    // Method to set the customer's first name
    public void setFirstName(String firstName) {
        this.firstName = firstName; // Sets the firstName
    }

    // Method to get the customer's last name
    public String getLastName() {
        return lastName; // Returns the lastName
    }

    // Method to set the customer's last name
    public void setLastName(String lastName) {
        this.lastName = lastName; // Sets the lastName
    }

    // Method to get the customer's email
    public String getEmail() {
        return email; // Returns the email
    }

    // Method to set the customer's email
    public void setEmail(String email) {
        this.email = email; // Sets the email
    }
}
