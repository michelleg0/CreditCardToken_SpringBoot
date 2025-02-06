package com.example.CreditCard_TokenProject.dao;

import com.example.CreditCard_TokenProject.dto.CreditCardDTO;
import com.example.CreditCard_TokenProject.utility.CreditCardTokenizer;
import com.example.CreditCard_TokenProject.utility.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreditCardDAO {

    //method inserts a credit card into the database

    public void insertCreditCard(CreditCardDTO creditCard) {
        String sql = "INSERT INTO credit_card (credit_card_token, last_four_cc_digits, expiration_month, expiration_year, customer_id, payment_processor_id) VALUES (?, ?, ?, ?, ?, ?)";
     // SQL query to insert a new credit card record
        String token = CreditCardTokenizer.tokenize(creditCard.getCreditCardNumber());
        String lastFourDigits = creditCard.getCreditCardNumber().substring(creditCard.getCreditCardNumber().length() - 4);

        //try-with-resources to get a database connection and prepare the SQL statement
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            //Values for the placeholders in the SQL query
            stmt.setString(1, token);
            stmt.setString(2, lastFourDigits);
            stmt.setByte(3, creditCard.getExpirationMonth());
            stmt.setByte(4, creditCard.getExpirationYear());
            stmt.setInt(5, creditCard.getCustomerId());
            stmt.setInt(6, creditCard.getPaymentProcessorId());

            //Execute the SQL query to insert the new credit card record
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Prints the error details if an exception occurs
            e.printStackTrace();
        }
    }
}
