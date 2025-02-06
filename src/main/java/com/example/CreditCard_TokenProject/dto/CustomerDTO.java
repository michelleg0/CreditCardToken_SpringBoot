package com.example.CreditCard_TokenProject.dto;

//Declaring class


// Declaring the CustomerDTO class
public class CustomerDTO {

    // Instance variables
    private String firstName; // Stores the customer's first name
    private String lastName;  // Stores the customer's last name
    private String email;     // Stores the customer's email
    private CreditCardDTO creditCard; // Stores the customer's credit card details

    // Constructor: Initializes a new CustomerDTO object
    // Parameters: firstName, lastName, email
    // Note: The creditCard instance variable should be properly initialized through the constructor or a setter method
    public CustomerDTO(String firstName, String lastName, String email) {
        this.firstName = firstName;  // Assigns the firstName parameter to the instance variable
        this.lastName = lastName;    // Assigns the lastName parameter to the instance variable
        this.email = email;          // Assigns the email parameter to the instance variable
        this.creditCard = creditCard; // This line is incorrect; it doesn't initialize creditCard properly
    }

    // Method to print the customer's details
    public void printCustomer() {
        System.out.println("Customer First Name: " + this.firstName); // Prints the customer's first name
        System.out.println("Customer Last Name: " + this.lastName);   // Prints the customer's last name
        System.out.println("Customer Email: " + this.email);          // Prints the customer's email
    }

    // Getter method for firstName
    public String getFirstName() {
        return firstName; // Returns the firstName
    }

    // Setter method for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName; // Sets the firstName
    }

    // Getter method for lastName
    public String getLastName() {
        return lastName; // Returns the lastName
    }

    // Setter method for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName; // Sets the lastName
    }

    // Getter method for email
    public String getEmail() {
        return email; // Returns the email
    }

    // Setter method for email
    public void setEmail(String email) {
        this.email = email; // Sets the email
    }

    // Getter method for creditCard
    public CreditCardDTO getCreditCard() {
        return creditCard; // Returns the creditCard
    }

    // Setter method for creditCard
    public void setCreditCard(CreditCardDTO creditCard) {
        this.creditCard = creditCard; // Sets the creditCard
    }
}
