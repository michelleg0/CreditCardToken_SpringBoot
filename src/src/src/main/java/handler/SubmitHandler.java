package main.java.handler; // Declaring the package

import com.sun.net.httpserver.HttpExchange; // Importing HttpExchange class for handling HTTP exchanges
import com.sun.net.httpserver.HttpHandler; // Importing HttpHandler interface for creating HTTP handlers
import java.io.IOException; // Importing IOException class for handling input-output exceptions
import java.io.InputStream; // Importing InputStream class for reading request body
import java.io.OutputStream; // Importing OutputStream class for sending response body
import java.nio.charset.StandardCharsets; // Importing StandardCharsets for UTF-8 encoding
import java.util.HashMap; // Importing HashMap class for storing form data
import java.util.Map; // Importing Map interface for key-value pairs
import main.java.dao.CustomerDAO; // Importing CustomerDAO class for interacting with Customer data access object
import main.java.dto.CustomerDTO; // Importing CustomerDTO class for representing Customer data transfer object

// Declaring the SubmitHandler class that implements HttpHandler
public class SubmitHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) { // Checking if the request method is POST
            InputStream is = exchange.getRequestBody(); // Getting the request body input stream
            String formData = new String(is.readAllBytes(), StandardCharsets.UTF_8); // Reading form data from input stream

            Map<String, String> params = parseFormData(formData); // Parsing form data into key-value pairs

            String firstName = params.get("firstName"); // Extracting firstName from form data
            String lastName = params.get("lastName"); // Extracting lastName from form data
            String email = params.get("email"); // Extracting email from form data

            CustomerDAO dao = new CustomerDAO(); // Creating an instance of CustomerDAO to interact with database

            try (OutputStream os = exchange.getResponseBody()) {
                int id = dao.insertCustomer(new CustomerDTO(firstName, lastName, email)); // Inserting customer data into database

                String response = "Customer with id " + id + " was successfully added";
                exchange.sendResponseHeaders(200, response.getBytes().length); // Sending HTTP response headers with status 200
                os.write(response.getBytes()); // Writing response message to response body
            }
        } else {
            exchange.sendResponseHeaders(405, -1); // Sending HTTP response headers with status 405 (Method Not Allowed)
        }
    }

    // Method to parse form data into key-value pairs
    private Map<String, String> parseFormData(String formData) {
        Map<String, String> params = new HashMap<>(); // Creating a HashMap to store parsed parameters
        String[] pairs = formData.split("&"); // Splitting form data into key-value pairs

        for (String pair : pairs) {
            String[] keyValue = pair.split("="); // Splitting each pair into key and value
            if (keyValue.length == 2) {
                String key = java.net.URLDecoder.decode(keyValue[0], StandardCharsets.UTF_8); // Decoding URL-encoded key
                String value = java.net.URLDecoder.decode(keyValue[1], StandardCharsets.UTF_8); // Decoding URL-encoded value
                params.put(key, value); // Storing key-value pair in HashMap
            }
        }
        return params; // Returning the parsed parameters
    }
}
