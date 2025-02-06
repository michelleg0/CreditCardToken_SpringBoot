package com.example.CreditCard_TokenProject.dto; // Declaring the package

// Declaring the CreditCardDTO class
public class CreditCardDTO {

    // The CC number should be string since this would be a long integer.
    private String creditCardNumber; // Stores the credit card number as a String
    private byte expirationMonth;    // Stores the expiration month as a byte
    private byte expirationYear;     // Stores the expiration year as a byte
    private String cvv;              // Stores the CVV code as a String
    private int customerId;          // Stores the customer ID as an int
    private int paymentProcessorId;  // Stores the payment processor ID as an int

    // Constructor to initialize the credit card details
    // Parameters: creditCardNumber, expirationMonth, expirationYear, cvv, customerId, paymentProcessorId
    public CreditCardDTO(String creditCardNumber, byte expirationMonth,
                         byte expirationYear, String cvv, int customerId, int paymentProcessorId){
        this.creditCardNumber = creditCardNumber;     // Assigns the creditCardNumber parameter to the instance variable
        this.expirationMonth = expirationMonth;       // Assigns the expirationMonth parameter to the instance variable
        this.expirationYear = expirationYear;         // Assigns the expirationYear parameter to the instance variable
        this.cvv = cvv;                               // Assigns the cvv parameter to the instance variable
        this.customerId = customerId;                 // Assigns the customerId parameter to the instance variable
        this.paymentProcessorId = paymentProcessorId; // Assigns the paymentProcessorId parameter to the instance variable
    }

    // Method to get the credit card number
    public String getCreditCardNumber() {
        return creditCardNumber; // Returns the creditCardNumber
    }

    // Method to set the credit card number
    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber; // Sets the creditCardNumber
    }

    // Method to get the expiration month
    public byte getExpirationMonth() {
        return expirationMonth; // Returns the expirationMonth
    }

    // Method to set the expiration month
    public void setExpirationMonth(byte expirationMonth) {
        this.expirationMonth = expirationMonth; // Sets the expirationMonth
    }

    // Method to get the expiration year
    public byte getExpirationYear() {
        return expirationYear; // Returns the expirationYear
    }

    // Method to set the expiration year
    public void setExpirationYear(byte expirationYear) {
        this.expirationYear = expirationYear; // Sets the expirationYear
    }

    // Method to get the CVV
    public String getCvv() {
        return cvv; // Returns the cvv
    }

    // Method to set the CVV
    public void setCvv(String cvv) {
        this.cvv = cvv; // Sets the cvv
    }

    // Method to get the customer ID
    public int getCustomerId() {
        return customerId; // Returns the customerId
    }

    // Method to set the customer ID
    public void setCustomerId(int customerId) {
        this.customerId = customerId; // Sets the customerId
    }

    // Method to get the payment processor ID
    public int getPaymentProcessorId() {
        return paymentProcessorId; // Returns the paymentProcessorId
    }

    // Method to set the payment processor ID
    public void setPaymentProcessorId(int paymentProcessorId) {
        this.paymentProcessorId = paymentProcessorId; // Sets the paymentProcessorId
    }
}
