package main.java.utility; // Declaring the package

import java.security.MessageDigest; // Importing MessageDigest class for creating a message digest instance
import java.security.NoSuchAlgorithmException; // Importing NoSuchAlgorithmException class for handling algorithm not found exception

// Declaring the CreditCardTokenizer class
public class CreditCardTokenizer {

    // Static method to tokenize a credit card number
    public static String tokenize(String creditCardNumber) {
        try {
            // Creating a MessageDigest instance for SHA-256
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            // Generating the hash of the credit card number
            byte[] encodedHash = messageDigest.digest(creditCardNumber.getBytes());

            // Converting the hash to a hexadecimal string
            StringBuilder hexStr = new StringBuilder();
            for (byte b : encodedHash) {
                // Converting each byte to a hex string
                String hex = Integer.toHexString(0xff & b);

                // Padding with leading zero if necessary
                if (hex.length() == 1) {
                    hexStr.append('0');
                }

                // Appending the hex string to the final result
                hexStr.append(hex);
            }

            // Returning the final tokenized string
            return hexStr.toString();

        } catch (NoSuchAlgorithmException e) {
            // Handling the case where SHA-256 algorithm is not available
            throw new RuntimeException(e);
        }
    }
}
