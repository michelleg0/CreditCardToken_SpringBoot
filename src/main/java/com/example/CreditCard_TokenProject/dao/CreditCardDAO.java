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

    // Fetches only the last four digits of credit cards
    public List<String> getLastFourDigits() {
        String sql = "SELECT last_four_cc_digits FROM credit_card";
        List<String> lastFourDigits = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lastFourDigits.add(rs.getString("last_four_cc_digits"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastFourDigits;
    }

    // Fetches only the credit card tokens
    public List<String> getCreditCardTokens() {
        String sql = "SELECT credit_card_token FROM credit_card";
        List<String> creditCardTokens = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                creditCardTokens.add(rs.getString("credit_card_token"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return creditCardTokens;
    }


}