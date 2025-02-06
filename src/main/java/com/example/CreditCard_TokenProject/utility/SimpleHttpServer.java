package com.example.CreditCard_TokenProject.utility; // Declaring the package

import com.sun.net.httpserver.HttpServer;
import com.example.CreditCard_TokenProject.handler.IndexHandler;
import com.example.CreditCard_TokenProject.handler.SubmitHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

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
