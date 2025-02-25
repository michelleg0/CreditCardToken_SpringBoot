package com.example.CreditCard_TokenProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.example.CreditCard_TokenProject.utility.DatabaseConnection;

public class CreditCardDAO {

    // Method to fetch the last four digits and tokens for all credit cards
    public List<Map<String, String>> getLastFourDigitsAndTokens() {
        String sql = "SELECT last_four_cc_digits, credit_card_token FROM credit_card"; // SQL query to fetch required fields
        List<Map<String, String>> creditCards = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Map<String, String> creditCardData = new HashMap<>();
                creditCardData.put("lastFourDigits", rs.getString("last_four_cc_digits"));
                creditCardData.put("token", rs.getString("credit_card_token"));
                creditCards.add(creditCardData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return creditCards;
    }

    // Optionally, add a method to fetch data by customer ID, etc., if needed
}