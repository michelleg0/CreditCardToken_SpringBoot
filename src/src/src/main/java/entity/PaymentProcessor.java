package main.java.entity; // Declaring the package

// Declaring the PaymentProcessor class
public class PaymentProcessor {

    // Instance variables
    public String name; // Stores the name of the payment processor
    public int id;      // Stores the ID of the payment processor

    // Constructor to initialize the payment processor details
    // Parameters: name, id
    public PaymentProcessor(String name, int id) {
        this.name = name; // Assigns the name parameter to the instance variable
        this.id = id;     // Assigns the id parameter to the instance variable
    }

    // Method to get the name of the payment processor
    public String getName() {
        return name; // Returns the name
    }

    // Method to set the name of the payment processor
    public void setName(String name) {
        this.name = name; // Sets the name
    }

    // Method to get the ID of the payment processor
    public int getId() {
        return id; // Returns the ID
    }

    // Method to set the ID of the payment processor
    public void setId(int id) {
        this.id = id; // Sets the ID
    }
}
