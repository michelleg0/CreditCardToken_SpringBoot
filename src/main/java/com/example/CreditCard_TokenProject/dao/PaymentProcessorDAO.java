package com.example.CreditCard_TokenProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.example.CreditCard_TokenProject.dto.PaymentProcessorDTO;
import com.example.CreditCard_TokenProject.entity.PaymentProcessor;
import com.example.CreditCard_TokenProject.utility.DatabaseConnection;
import com.example.CreditCard_TokenProject.utility.DbConstants;


public class PaymentProcessorDAO {
    // Method to insert a new payment processor and return their ID
    public int insertPaymentProcessor(PaymentProcessorDTO paymentProcessor) {
        String sql = "INSERT INTO payment_processor (name) VALUES (?)";

        int newId = -1;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, paymentProcessor.getName());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Inserting payment processor failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newId;
    }
// Method to get all payment processors from the database and return a list of payment processor objects

    public List<PaymentProcessor> getAllPaymentProcessors() {
        String sql = "SELECT id, name FROM payment_processor";

        List<PaymentProcessor> paymentProcessors = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt(DbConstants.ID);
                String name = rs.getString(DbConstants.NAME);

                paymentProcessors.add(new PaymentProcessor(name, id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentProcessors;
    }

    // Method to get a payment processor by their ID and return a payment processor object
    public PaymentProcessor getPaymentProcessor(int id) {
        String sql = "SELECT id, name FROM payment_processor WHERE id = ?";

        PaymentProcessor paymentProcessor = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int paymentProcessorId = rs.getInt(DbConstants.ID);
                    String name = rs.getString(DbConstants.NAME);

                    paymentProcessor = new PaymentProcessor(name, paymentProcessorId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paymentProcessor;
    }
}
