package main.java.dto; // Declaring the package

// Declaring the PaymentProcessorDTO class
public class PaymentProcessorDTO {

    // Instance variables
    private String name; // Stores the name of the payment processor
    private int id;      // Stores the ID of the payment processor

    // Constructor to initialize the payment processor details
    // Parameters: name, id
    public PaymentProcessorDTO(String name) {
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
