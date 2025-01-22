package main.java.utility; // Declaring the package

import java.io.IOException; // Importing IOException class for handling input-output exceptions
import java.io.InputStream; // Importing InputStream class for reading byte streams
import java.util.Properties; // Importing Properties class for handling configuration properties

// Declaring the Config class
public class Config {
    private static final Properties properties = new Properties(); // Creating a Properties object to hold configuration data

    // Static block to initialize the properties object
    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            // Attempting to load the properties file
            if (input == null) {
                throw new IOException("Sorry, unable to find config.properties");
            }

            // Loading the properties from the input stream
            properties.load(input);
        } catch (IOException ex) {
            // Handling any IOExceptions that occur
            ex.printStackTrace();
        }
    }

    // Method to retrieve a property value by key
    public static String get(String key) {
        // Getting the property value associated with the key
        String value = properties.getProperty(key);

        // Checking if the value is null
        if (value == null) {
            throw new IllegalArgumentException("Key not found in properties file: " + key);
        }

        // Returning the property value
        return value;
    }
}
