package main.java.utility; // Declaring the package

import com.sun.net.httpserver.HttpServer; // Importing HttpServer class from the com.sun.net.httpserver package
import java.io.IOException; // Importing IOException class for handling input-output exceptions
import java.net.InetSocketAddress; // Importing InetSocketAddress class for creating socket addresses
import main.java.handler.IndexHandler; // Importing IndexHandler class from the handler package
import main.java.handler.SubmitHandler; // Importing SubmitHandler class from the handler package

// Declaring the SimpleHttpServer class
public class SimpleHttpServer {

    // Main method - entry point of the application
    public static void main(String[] args) throws IOException {
        // Creating an HttpServer instance bound to port 8080 with a default backlog of 0
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Creating a context for the root path ("/") and associating it with IndexHandler
        server.createContext("/", new IndexHandler());

        // Creating a context for the "/submit" path and associating it with SubmitHandler
        server.createContext("/submit", new SubmitHandler());

        // Setting the server's executor to null, which creates a default executor
        server.setExecutor(null);

        // Starting the server
        server.start();

        // Printing a message to indicate the server has started
        System.out.println("Server started at http://localhost:8080/");
    }
}
