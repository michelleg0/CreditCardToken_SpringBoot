package com.example.CreditCard_TokenProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.List;  // ✅ This is fine

import com.example.CreditCard_TokenProject.dto.CustomerDTO;
import com.example.CreditCard_TokenProject.entity.Customer;
import com.example.CreditCard_TokenProject.utility.DatabaseConnection;
import com.example.CreditCard_TokenProject.utility.DbConstants;


public class CustomerDAO {
    public int insertCustomer(CustomerDTO customer) {
        // Method to insert a new customer and return their ID
        String sql = "INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)";

        int newId = -1;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getFirstName());
            stmt.setString(2, customer.getLastName());
            stmt.setString(3, customer.getEmail());

            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    newId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Inserting customer failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return newId;
    }
   //Method to get all customers from the database and return a list of customer objects
    public List<Customer> getAllCustomers() {
        String sql = "SELECT id, first_name, last_name, email FROM customer";

        List<Customer> customers = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt(DbConstants.ID);
                String firstName = rs.getString(DbConstants.FIRST_NAME);
                String lastName = rs.getString(DbConstants.LAST_NAME);
                String email = rs.getString(DbConstants.EMAIL);

                customers.add(new Customer(id, firstName, lastName, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
    // Method to get a customer by their ID and return a customer object
    public Customer getCustomer(int id) {
        String sql = "SELECT id, first_name, last_name, email FROM customer WHERE id = ?";

        Customer customer = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int customerId = rs.getInt(DbConstants.ID);
                    String firstName = rs.getString(DbConstants.FIRST_NAME);
                    String lastName = rs.getString(DbConstants.LAST_NAME);
                    String email = rs.getString(DbConstants.EMAIL);

                    customer = new Customer(customerId, firstName, lastName, email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }
}
